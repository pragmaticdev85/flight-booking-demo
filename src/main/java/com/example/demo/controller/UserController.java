package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.google.common.collect.Lists;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = "application/json")
    public void saveUser(@RequestBody @Valid User user) {
        userRepository.save(user);
    }

    @GetMapping(produces = "application/json")
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }
}
