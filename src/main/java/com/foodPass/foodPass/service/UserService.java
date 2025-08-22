
package com.foodPass.foodPass.service;


import com.foodPass.foodPass.model.db.User;
import com.foodPass.foodPass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> registerUser(User user) {
        return userRepository.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.<User>error(new RuntimeException("User already exists")))
                .switchIfEmpty(userRepository.save(user));

    }
}