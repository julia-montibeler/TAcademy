package com.example.posts.post_params.respositories;

import com.example.posts.post_params.domain.Consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
