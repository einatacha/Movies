package com.example.Movies.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Movies.entities.User;
import com.example.Movies.repository.UserRepository;
@Service
public class UserService {


        @Autowired
        private UserRepository userRepository;

        public List<User> findAll() {
            return userRepository.findAll();
        }

        public List<User> findById(long userId){
            return userRepository.findById(userId);
        }

        public void save(User user) {
            userRepository.save(user);
        }


    }

