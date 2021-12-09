package com.example.Movies.controller;

import  java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Movies.controller.dto.UserDto;
import com.example.Movies.entities.User;
import com.example.Movies.service.UserService;

import  io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<UserDto> list(){
        List<User> user = userService.findAll();
        return UserDto.convert(user);
    }

    @GetMapping(value = "/user/{id}")
    public List<UserDto> listUser(@PathVariable(value="id") long id){

        List<User> user = userService.findById(id);
        if(user != null) {

            return UserDto.convertUser(user);
        }

        List<User> users = userService.findAll();
        return UserDto.convert(user);
    }

    @PostMapping(value = "/user/register")
    public ResponseEntity<User> Register(@RequestBody @Validated User user, UriComponentsBuilder uriBuilder) {
        userService.save(user);

        URI uri = uriBuilder.path("/movies/user/register/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }


}





