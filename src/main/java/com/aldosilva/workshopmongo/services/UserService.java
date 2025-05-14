package com.aldosilva.workshopmongo.services;

import com.aldosilva.workshopmongo.domain.User;
import com.aldosilva.workshopmongo.dtos.UserDTO;
import com.aldosilva.workshopmongo.exeptions.NotFoundExeption;
import com.aldosilva.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDTO buscarUserPorId(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Usuario não encontrado"));
        return new UserDTO(user);
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        buscarUserPorId(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    updateData(existingUser, user);
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user.getId()));
    }


    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }



}
