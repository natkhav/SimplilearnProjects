package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByLoginUsernameAndLoginPassword(username, password);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findBySearchParameter(String parameter) {
        return userRepository.findByFirstNameContainsOrLastNameContainsOrEmailContains(parameter, parameter, parameter);
    }
}
