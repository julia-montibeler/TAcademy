package com.example.posts.post_params.controllers;

import com.example.posts.post_params.domain.Consulta.Consulta;
import com.example.posts.post_params.domain.Consulta.ConsultaRequestDTO;
import com.example.posts.post_params.domain.Consulta.ConsultaResponseDTO;
import com.example.posts.post_params.respositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> getConsultas(){
        return ResponseEntity.ok(consultaRepository.findAll().stream().map(ConsultaResponseDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity postConsulta(@RequestBody @Valid ConsultaRequestDTO body){
        Consulta newProduct = new Consulta(body);

        this.consultaRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }
}