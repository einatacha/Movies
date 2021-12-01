package com.example.Movies.repository;

import com.example.Movies.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Long> { // user ou name ?
   Optional<User> findByEmail(String email);
}
