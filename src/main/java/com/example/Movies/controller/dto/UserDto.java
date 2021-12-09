package com.example.Movies.controller.dto;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Movies.entities.Languages;
import com.example.Movies.entities.User;
import com.example.Movies.entities.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDto {


        private Long id;

        private String name;

        private String CPF;

        private int cellPhone;

        private String email;

        private boolean active = true;

        private String profiles;


        private Languages languages;

        public UserDto(User user) {
            super();
            this.id = user.getId();
            this.name = user.getName();
            this.cellPhone = user.getCellPhone();
            this.email = user.getEmail();
            this.active = user.isActive();
            this.languages = user.getLanguages();
            this.CPF = user.getCPF();
            this.profiles = user.getProfiles();
        }

        public static List<UserDto> convert(List<User> user) {
            return user.stream().map(UserDto::new).collect(Collectors.toList());
        }

        public static List<UserDto> convertUser(List<User> user) {
            return user.stream().map(UserDto::new).collect(Collectors.toList());
        }




    }




