package com.example.posts.post_params.respositories;

import com.example.posts.post_params.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRespository extends JpaRepository<Livro, Long> {
}
