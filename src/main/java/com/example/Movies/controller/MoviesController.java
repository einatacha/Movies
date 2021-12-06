package com.example.Movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MoviesController {

    @GetMapping(value = "/success")
    public String success() {
        return "Dell Api Success!";
    }


}


