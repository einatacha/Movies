package com.example.Movies.controller;

import com.example.Movies.entities.User;
import com.example.Movies.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api
@RestController
@RequestMapping(value = "/movies")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> listUser(){
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public List<User> listUser(@PathVariable(value="id") long id){

        List<User> user = userService.findById(id);
        if(user != null) {

            return userService.findById(id);
        }

        return userService.findAll();
    }

   @PostMapping(value = "/user/register")
     public User createUser(@RequestBody @Valid User user)   {
//        try{
            return userService.save(user);
//        }
//        catch(Exception e){
//            System.out.println("Informações inválidas");
//       }
//     finally {
//            return null;
//        }
}

    @PutMapping(value = "/user/update/{id}")
    public User update (@PathVariable Long id, @RequestBody @Valid User user) {
        return  this.userService.update(user);
    }

    @DeleteMapping(value = "user/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping(value = "/users/active/{id}")
    public User active (@PathVariable Long id, @RequestBody @Valid User user) {
        user.setActive(false);
        return  this.userService.update(user);
    }
}




