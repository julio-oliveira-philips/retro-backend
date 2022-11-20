package com.br.retrobackend.service;

import com.br.retrobackend.entitys.User;
import com.br.retrobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User save(User user) {

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return this.userRepository.save(newUser);

    }

    public Boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
