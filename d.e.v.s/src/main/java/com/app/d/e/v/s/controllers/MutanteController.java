package com.app.d.e.v.s.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devs")
public class MutanteController {
    @GetMapping("/protect")
    public String protectedRoute() {
        return "Rota Protegida";
    }

    @GetMapping("/free")
    public String unprotectedRoute() {
        return "Rota Livre";
    }
}
