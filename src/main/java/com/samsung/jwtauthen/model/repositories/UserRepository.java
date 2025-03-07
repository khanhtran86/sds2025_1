package com.samsung.jwtauthen.model.repositories;

import com.samsung.jwtauthen.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
