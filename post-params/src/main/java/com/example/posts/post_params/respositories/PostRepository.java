package com.example.posts.post_params.respositories;

import com.example.posts.post_params.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>, JpaSpecificationExecutor<PostModel> {


}
