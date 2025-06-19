package com.aldosilva.workshopmongo.resources;

import com.aldosilva.workshopmongo.domain.Post;
import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.UserDTO;
import com.aldosilva.workshopmongo.services.PostService;
import com.aldosilva.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok(postService.buscarPostPorId(id));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        return ResponseEntity.ok(postService.findByTitle(text));
    }

}
