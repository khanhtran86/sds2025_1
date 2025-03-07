package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.viewmodels.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
