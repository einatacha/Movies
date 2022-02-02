package com.example.Movies.configuration.security;
//QUEBRADO

import com.example.Movies.repository.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Authentication Authentication;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(Authentication).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .cors().and()
        .authorizeRequests()
       
                .antMatchers(HttpMethod.GET, "/movies/user").permitAll()
                .antMatchers(HttpMethod.GET, "/movies/user/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/movies/list").permitAll()
                .antMatchers(HttpMethod.GET, "/movies/list/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/movies/category").permitAll()
                .antMatchers(HttpMethod.GET, "/movies/category/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/movies/category/register").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/category/update/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/movies/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/movies/register").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/user/update/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/update/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/update/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/user/active/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/category/active/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/movies/active/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/movies/user/delete/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/movies/delete/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/movies/category/delete/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()

                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and().addFilterBefore(new AuthenticationForTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {


    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//       CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("*"));
//            configuration.setAllowedMethods(Arrays.asList("*"));
//            configuration.setAllowedHeaders(Arrays.asList("*"));
//            configuration.setAllowCredentials(true);
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//    }
//    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Set the routes that are allowed across the domain
        registry.addMapping("/**")
                // Set the domain name that allows cross-domain requests
                .allowedOrigins("*")
                // whether to allow certificates (cookies)
                .allowCredentials(true)
                // set the allowed methods
                .allowedMethods("*")
                // Allowed time across domains
                .maxAge(3600);
    }

//}
    
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }
}















