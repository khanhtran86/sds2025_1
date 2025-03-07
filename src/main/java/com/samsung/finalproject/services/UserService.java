package com.samsung.finalproject.services;

import com.samsung.finalproject.models.repositories.UserRepository;
import com.samsung.finalproject.models.viewmodels.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
