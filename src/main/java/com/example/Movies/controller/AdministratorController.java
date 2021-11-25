package com.example.Movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministratorController {
    @GetMapping("/administrator")
    public String index(){
        return "administrator/index";
    }

}
