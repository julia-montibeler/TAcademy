package com.example.posts.post_params.controllers;

import com.example.posts.post_params.domain.user.*;
import com.example.posts.post_params.infra.security.TokenService;
import com.example.posts.post_params.respositories.UserRepository;
import com.example.posts.post_params.services.InMemoryTokenBlacklist;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    InMemoryTokenBlacklist tokenBlacklist = new InMemoryTokenBlacklist();

    @Autowired
    private AuthenticationManager authenticationManager;

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth =  this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerenateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassword =  new BCryptPasswordEncoder().encode(data.password());

        this.userRepository.save(new User(data.login(), encryptedPassword, data.role()));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String token = tokenBlacklist.extractTokenFromRequest(request);

        tokenBlacklist.addToBlacklist(token);

        return ResponseEntity.ok("Logged out successfully");
    }


}