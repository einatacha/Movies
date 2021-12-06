package com.example.Movies.controller;

import com.example.Movies.configuration.form.LoginForm;
import com.example.Movies.controller.dto.TokenDto;
import com.example.Movies.configuration.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
     private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dataLogin = form.convert();

       try {
           Authentication authentication = authManager.authenticate(dataLogin);
           String token = tokenService.generateToken(authentication);
           return ResponseEntity.ok(new TokenDto(token,"Bearer"));
       } catch (AuthenticationException e) {
           return ResponseEntity.badRequest().build();
       }
    }
}
