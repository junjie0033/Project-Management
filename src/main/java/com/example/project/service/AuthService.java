package com.example.project.service;

import com.example.project.controller.request.RegisterRequest;
import com.example.project.entity.Authority;
import com.example.project.entity.User;
import com.example.project.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class AuthService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()) != null) {
            return null;
        } else {
            System.out.println(request.getUsername() + " " + request.getPassword() + " ");
            String password = passwordEncoder.encode(request.getPassword());
            HashSet<Authority> set = new HashSet<>();
            User user = new User(request.getUsername(), password, request.getEmail(), set);
            userRepository.save(user);
            return userRepository.findByUsername(user.getUsername());
        }
    }


    public boolean passwordMach(String give, String store) {
        return passwordEncoder.matches(give, store);
    }


}
