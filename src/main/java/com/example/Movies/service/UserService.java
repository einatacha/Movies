package com.example.Movies.service;
import java.util.List;
import java.util.Optional;


import com.example.Movies.service.exception.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Movies.entities.Movies;
import com.example.Movies.entities.User;
import com.example.Movies.repository.UserRepository;
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

//public Optional<Movies> findById(Long moviesId){
//        return moviesRepository.findById(moviesId);
//        }
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

//     public List<User>findByCpf(String cpf){return userRepository.findByCpf(cpf); }

    public User findByEmail(String email) {
        Optional<User> obj = userRepository.findByEmail(email);

        return obj.orElse(null);
    }


    public User save(@RequestBody User user) {
        if(userRepository.existsByCpf(user.getCpf())) {
            throw new BadRequestException("CPF already exist in the database");
        }
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exist in the database");
        }

//       if (email != null ){
//           throw new BadRequestException("email já existe no banco de dados");
//       }
////
//       var cpf = findByCpf(user.getCpf());
//		if(cpf != null) {
//        throw new BadRequestException("cpf já existe no banco de dados");
//    }
//        user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
   }


    public User update(User user) {
    findById(user.getId());

    user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.saveAndFlush(user);

}
    public void deleteById(Long id) {
        userRepository.deleteById(id) ; }
}

