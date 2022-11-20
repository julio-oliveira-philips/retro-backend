package com.br.retrobackend.service;

import com.br.retrobackend.entitys.User;
import com.br.retrobackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return this.userRepository.findById(id);
    }

    public void deleteById(Integer id) {
        this.userRepository.deleteById(id);
    }
}
