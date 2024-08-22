package com.tacademy.projeto2008.services;

import com.tacademy.projeto2008.models.PostModel;
import com.tacademy.projeto2008.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostModel> getPosts(Specification<PostModel> spec) {
        return postRepository.findAll(spec);
    }

    public List<PostModel> getPosts(Specification<PostModel> spec, int start, int end) {
        return postRepository.findAll(spec);
    }



    public List<PostModel> getPostByViewsGreaterThan(Integer views) {
        return postRepository.findByViewsGreaterThan(views);
    }

    public List<PostModel> getPostsByViewsLessThan(Integer views) {
        return postRepository.findByViewsLessThan(views);
    }

    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }
}
