package com.example.springprojectmain.repository;

import com.example.springprojectmain.entities.MyUser;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<User> findByUsername(String username);
}
