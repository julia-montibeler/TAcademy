package com.app.viagens.repositories;

import com.app.viagens.models.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViagemRepository extends JpaRepository<ViagemModel, Long> {
    List<ViagemModel> findByDestinoId(Long id);
}
