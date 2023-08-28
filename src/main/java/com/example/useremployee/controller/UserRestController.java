package com.example.useremployee.controller;

import com.example.useremployee.model.User;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping (path = "users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
