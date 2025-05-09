package com.aldosilva.workshopmongo.services;

import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.UserDTO;
import com.aldosilva.workshopmongo.exeptions.NotFoundExeption;
import com.aldosilva.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public UserDTO buscarUserPorId(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Usuario não encontrado"));
        return new UserDTO(user);
    }


}
