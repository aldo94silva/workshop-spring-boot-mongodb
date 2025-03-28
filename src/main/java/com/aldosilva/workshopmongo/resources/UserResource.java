package com.aldosilva.workshopmongo.resources;

import com.aldosilva.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User silva = new User(1L, "Aldo Silva", "aldo.silva@outlook.com");
        User alex = new User(2L, "Alex Silva", "alex.silva@outlook.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(silva,alex));
        return ResponseEntity.ok().body(list);
    }

}
