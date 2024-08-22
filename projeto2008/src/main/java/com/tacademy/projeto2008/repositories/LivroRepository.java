package com.tacademy.projeto2008.repositories;

import com.tacademy.projeto2008.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
