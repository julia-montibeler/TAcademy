package com.tacademy.livro.controllers;

import com.tacademy.livro.dtos.LivroRecordDto;
import com.tacademy.livro.models.LivroModel;
import com.tacademy.livro.repositories.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
@CrossOrigin(origins = "http://localhost:4200/")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable(value="id") UUID id) {
        Optional<LivroModel> product = livroRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        }

    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<Object> getLivroByGenero(@PathVariable(value="genero") String genero) {
        Optional<LivroModel> product = livroRepository.findByGenero(genero);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros registrados para esse genero");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        }

    }

    @PostMapping("/cadastro")
    public ResponseEntity<LivroModel> addLivro(@RequestBody @Valid LivroRecordDto livroDto) {
        LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(livroDto, livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteLivro(@PathVariable(value="id") UUID id) {
        Optional<LivroModel> livroO = livroRepository.findById(id);
        if (livroO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            livroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Livro excluído com sucesso");
        }
    }

    @PutMapping("/id")
    public ResponseEntity<Object> updateLivro(@PathVariable(value="id") UUID id, @RequestBody @Valid LivroRecordDto livroRecordDto) {
        Optional<LivroModel> livroO = livroRepository.findById(id);
        if (livroO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            var livroModel = livroO.get();
            BeanUtils.copyProperties(livroRecordDto, livroModel);
            return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroModel));
        }
    }
}
