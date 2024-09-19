package com.example.posts.post_params.domain.user;

public enum UserRole {

    ADMIN("admin"),

    MEDICO("medico"),

    PACIENTE("paciente"),

    RECEPCIONISTA("recepcionista");



    private String role;

    UserRole(String role){
        this.role = role;
    }

}
