package com.tacademy.livro.repositories;

import com.tacademy.livro.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository  extends JpaRepository<LivroModel, UUID> {
    public Optional<LivroModel> findByGenero(String genero);
}
