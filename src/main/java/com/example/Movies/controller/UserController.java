package com.example.Movies.controller;

//import com.example.Movies.entities.Movies;
import com.example.Movies.entities.User;
import com.example.Movies.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Api
@RestController
@RequestMapping(value = "/movies")

public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @GetMapping(value = "/user")
    public List<User> listUser(){
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/user/{id}")
    public Optional<User> listUser(@PathVariable("id") Long id){

        
            return userService.findById(id);
        }

    
    @CrossOrigin
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
    @CrossOrigin
    @PutMapping(value = "/user/update/{id}")
    public User update (@PathVariable Long id, @RequestBody @Valid User user) {
        return  this.userService.update(user);
    }
    @CrossOrigin
    @DeleteMapping(value = "user/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/users/active/{id}")
    public User active (@PathVariable Long id, @RequestBody @Valid User user) {
        user.setActive(false);
        return  this.userService.update(user);
    }
}




