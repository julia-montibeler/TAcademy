package com.app.d.e.v.s.repositories;

import com.app.d.e.v.s.models.MutanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutanteRepository extends JpaRepository<MutanteModel, Long> {
    int countByNaInstituicao(boolean naInstituicao);

    List<MutanteModel> findByNaInstituicao(boolean naInstituicao);
}
