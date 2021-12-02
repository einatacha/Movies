package com.example.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Parameter;


    @SpringBootApplication
    public class MoviesApplication {

        public static void main(String[] args) {
            SpringApplication.run(MoviesApplication.class, args);

        }
    }