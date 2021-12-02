package com.example.Movies.controller;

import com.example.Movies.configuration.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;
 private TokenService tokenService
    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Validated LoginForm form){
        UsernamePasswordAuthenticationToken dataLogin = form.convert();

//        System.out.println(form.getEmail());// verificar no postman depois apague
//        System.out.println(form.getPassword());
       try {
           Authentication authentication = authManager.authenticate(dataLogin);
        //   return ResponseEntity.ok().build();
           String token = tokenService.generateToken(authentication);
       }
       catch (AuthenticationException e) {
           return ResponseEntity.badRequest().build();
       }
    }
}
