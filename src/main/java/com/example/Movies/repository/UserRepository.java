package com.example.Movies.repository;

import com.example.Movies.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Long> {
   Optional<User> findByEmail(String email);

   Optional<User> findByCpf(String cpf);

//   List<User> findByCpf(String cpf);

//   List<User> findById(long userId);

   boolean existsByCpf(String cpf);

   boolean existsByEmail(String email);

}
