package com.example.posts.post_params.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String password;

    private UserRole role;

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (this.role == UserRole.MEDICO){
            return List.of(new SimpleGrantedAuthority("ROLE_MEDICO"));
        } else if (this.role == UserRole.PACIENTE) {
            return List.of(new SimpleGrantedAuthority("ROLE_PACIENTE"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_RECEPCIONISTA"));
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
