package com.example.Movies.configuration.security;
import java.util.Date;
import com.example.Movies.entities.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
@Service
public class TokenService {

    @Value("${movies.jwt.expiration}")
    private String expiration;


    @Value("${movies.jwt.expiration}")
    private String secret;

    public String generateToken(Authentication authentication){
     User loggedUser = (User)  authentication.getPrincipal();
     Date today = new Date();
     Date  expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

       return  Jwts.builder()
                .setIssuer("Creator")
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}
