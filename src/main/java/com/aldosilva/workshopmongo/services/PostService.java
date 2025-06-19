package com.aldosilva.workshopmongo.services;

import com.aldosilva.workshopmongo.domain.Post;
import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.UserDTO;
import com.aldosilva.workshopmongo.exeptions.NotFoundExeption;
import com.aldosilva.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findPostsByUserId(String userId) {
        return postRepository.findByAuthorId(userId);
    }

    public Post buscarPostPorId(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Post não encontrado"));
        return post;
    }
}
