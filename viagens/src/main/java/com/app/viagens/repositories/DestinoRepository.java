package com.app.viagens.repositories;

import com.app.viagens.models.DestinoModel;
import com.app.viagens.models.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Long> {

}
