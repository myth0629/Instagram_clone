package com.example.instagram_clone.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRespository extends JpaRepository<User, Long>{
    User findByEmail(String email);

    Optional<Object> findByUsername(String username);
}
