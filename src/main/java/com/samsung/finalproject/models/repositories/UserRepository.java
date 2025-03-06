package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.viewmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
