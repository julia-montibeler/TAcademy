package com.tacademy.projeto2008.services;

import com.tacademy.projeto2008.models.LivroModel;
import com.tacademy.projeto2008.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> buscarLivros(Example<LivroModel> example) {
        return livroRepository.findAll(example);
    }
}
