package com.tacademy.projeto2008.repositories;

import com.tacademy.projeto2008.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>, JpaSpecificationExecutor<PostModel> {
    List<PostModel> findByViewsGreaterThan(Integer views);
    List<PostModel> findByViewsLessThan(Integer views);

    List<PostModel> findAll();
}
