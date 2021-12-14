package com.example.Movies.service;

import javax.validation.Valid;

import com.example.Movies.entities.Movies;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
//    @Autowired
//    private MoviesRepository moviesRepository;
//    public List<Movies>findAll(){
//        return moviesRepository.findAll();
//    }
//    public List<Movies>findById(long userId){
//        return moviesRepository.findById(userId);
//    }
//
//    public void save(Movies movies) {
//        moviesRepository.save(movies);
@Autowired
private MoviesRepository moviesRepository;

public List<Movies> findAll() {
        return moviesRepository.findAll();
        }

public List<Movies> findById(long userId){
        return moviesRepository.findById(userId);
        }

public Movies save(@RequestBody Movies movies) {
        return moviesRepository.save(movies);
        }

public Movies update(@Valid Movies movies) {
        findById(movies.getId());
        return moviesRepository.saveAndFlush(movies);
    }
}

