package com.example.useremployee.controller;

import com.example.useremployee.model.User;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping (path = "users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @PostMapping (path = "user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> putMapping(@PathVariable int id, @RequestBody User user) {
        Optional<User> orgStudent = userRepository.findById(id);
        if (orgStudent.isPresent()) {
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
            //return ResponseEntity.ok(student)
        } else {
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
    }

    //Delete Student
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<User> orgStudent = userRepository.findById(id);
        if (orgStudent.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

}
