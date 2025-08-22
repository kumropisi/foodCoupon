package com.foodPass.foodPass.controller;


import com.foodPass.foodPass.model.db.User;
import com.foodPass.foodPass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/foodpass")
@CrossOrigin(origins = "http://localhost:5173")
public class FoodPassController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user)
                .map(savedUser -> "User registered successfully with ID: " + savedUser.getId())
                .onErrorResume(e -> Mono.just("Error: " + e.getMessage()));
    }
}