package com.example.Movies.controller;

import com.example.Movies.entities.Movies;

import com.example.Movies.service.MoviesService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping(value = "/list")
    public List<Movies> listMovies(){
        return moviesService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public List<Movies> listMovies(@PathVariable(value="id") long id){

        List<Movies> movies = moviesService.findById(id);
        if(movies != null) {

            return moviesService.findById(id);
        }

        return moviesService.findAll();
    }

    @PostMapping(value = "/register")
    public Movies createMovies(@RequestBody @Valid Movies movies) {
        return moviesService.save(movies);
    }

    @PutMapping(value = "/update/{id}")
    public Movies update (@PathVariable Long id, @RequestBody @Valid Movies movies) {
        return  this.moviesService.update(movies);
    }
}