package com.example.Movies.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movies {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "id", nullable = false)
        private long id;
//
//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "title", nullable = false)
        private String title;
//
//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "categorys", nullable = false)
        private String categorys;

//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(columnDefinition = "TEXT")
        private String synopsis;

//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(columnDefinition = "TEXT")
        private String image;


        @Column(name = "active")
        private boolean active = true;

        @Column(name = "releasedate")
        private String releaseDate;

//        @NotNull(message =  "Este campo não pode ser nulo" )
//        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "duration")
        private String duration;



        @ManyToOne
        @JoinColumn(name = "languages_id")
        private Languages languages;


        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;



    }




