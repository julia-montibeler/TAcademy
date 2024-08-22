package com.tacademy.projeto2008.controllers;

import com.tacademy.projeto2008.models.LivroModel;
import com.tacademy.projeto2008.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> buscarLivro(
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "autor", required = false) String autor,
            @RequestParam(value = "categoria", required = false) String categoria,
            @RequestParam(value = "preco_gt", required = false) Double precoGt
    ) {
        LivroModel livroModel = new LivroModel();
        livroModel.setTitulo(titulo);
        livroModel.setAutor(autor);
        livroModel.setCategoria(categoria);
        livroModel.setPreco(BigDecimal.valueOf(precoGt));

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<LivroModel> example = Example.of(livroModel, matcher);
        List<LivroModel> livros = livroService.buscarLivros(example);
        return ResponseEntity.ok(livros);
    }
}
