package com.aldosilva.workshopmongo.repositories;

import com.aldosilva.workshopmongo.domain.Post;
import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByAuthorId(String authorId);

}
