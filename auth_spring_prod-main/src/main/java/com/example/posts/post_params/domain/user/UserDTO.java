package com.example.posts.post_params.domain.user;

public record UserDTO(String id, String login, String password, UserRole role) {
}
