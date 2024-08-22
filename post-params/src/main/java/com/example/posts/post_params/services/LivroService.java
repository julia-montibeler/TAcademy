package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Livro;
import com.example.posts.post_params.respositories.LivroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroService {

    @Autowired
    private LivroRespository livroRespository;

    public List<Livro> buscarLivros(Example<Livro> example){
        return livroRespository.findAll(example);
    }
}
