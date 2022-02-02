package com.example.Movies.controller;

import com.example.Movies.entities.Movies;

import com.example.Movies.entities.User;
import com.example.Movies.service.MoviesService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;
    
    @CrossOrigin
    @GetMapping(value = "/list")
    public List<Movies> listMovies() {
        return moviesService.findAll();
    }
    @CrossOrigin
    @GetMapping(value = "/list/{id}")
    public Optional<Movies> listMovies(@PathVariable("id") Long id
) {


            return moviesService.findById(id);
       
     
    }
    
    @CrossOrigin
    @PostMapping(value = "/register")
    public Movies createMovies(@RequestBody @Valid Movies movies) {
        return moviesService.save(movies);
    }
    @CrossOrigin
    @PutMapping(value = "/update/{id}")
    public Movies update(@PathVariable Long id, @RequestBody @Valid Movies movies) {
        return this.moviesService.update(movies);
    }
    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        moviesService.deleteById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/active/{id}")
    public Movies active(@PathVariable Long id , @RequestBody @Valid Movies movies) {
        movies.setActive(false);
        return this.moviesService.update(movies);
    }
}
