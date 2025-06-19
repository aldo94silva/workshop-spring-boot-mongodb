package com.aldosilva.workshopmongo.config;

import com.aldosilva.workshopmongo.domain.Post;
import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.AuthorDTO;
import com.aldosilva.workshopmongo.dtos.ComentDTO;
import com.aldosilva.workshopmongo.repositories.PostRepository;
import com.aldosilva.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
        stf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, stf.parse("21/03/2018"), "Partiu viagem",
                "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, stf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",
                new AuthorDTO(maria));

        ComentDTO c1 = new ComentDTO("Boa viagem mano!", stf.parse("2018/03/21"), new AuthorDTO(alex));
        ComentDTO c2 = new ComentDTO("Aproveite!", stf.parse("2018/03/22"), new AuthorDTO(bob));
        ComentDTO c3 = new ComentDTO("Tenha um ótimo dia!", stf.parse("2018/03/23"), new AuthorDTO(alex));

        post1.getComents().addAll(Arrays.asList(c1, c2));
        post2.getComents().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }
}
