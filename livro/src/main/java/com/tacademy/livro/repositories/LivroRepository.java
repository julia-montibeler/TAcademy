package com.tacademy.livro.repositories;

import com.tacademy.livro.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository  extends JpaRepository<LivroModel, UUID> {
}
