package com.example.posts.post_params.services;

import com.example.posts.post_params.models.PostModel;
import com.example.posts.post_params.respositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostModel> getPosts(Specification<PostModel> spec){
        return postRepository.findAll(spec);
    }


}
