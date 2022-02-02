package com.example.Movies.service;

import javax.validation.Valid;

import com.example.Movies.entities.Movies;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

@Autowired
private MoviesRepository moviesRepository;

public List<Movies> findAll() {
        return moviesRepository.findAll();
        }

public Optional<Movies> findById(Long moviesId){
        return moviesRepository.findById(moviesId);
        }

public Movies save(@RequestBody Movies movies) {
        return moviesRepository.save(movies);
        }

public Movies update(@Valid Movies movies) {
        findById(movies.getId());
        return moviesRepository.saveAndFlush(movies);
    }
        public void deleteById(Long id) {
                moviesRepository.deleteById(id);
        }
}

