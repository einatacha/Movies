package com.example.Movies.configuration.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String generateToken(Authentication authentication){
       authentication.getPrinci
        JwtBuilder creator = Jwts.builder()
                .setIssuer("Creator")
                .setSubject(sub);

    }
}
