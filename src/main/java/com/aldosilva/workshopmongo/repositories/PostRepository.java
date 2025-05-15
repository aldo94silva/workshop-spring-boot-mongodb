package com.aldosilva.workshopmongo.repositories;

import com.aldosilva.workshopmongo.domain.Post;
import com.aldosilva.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
