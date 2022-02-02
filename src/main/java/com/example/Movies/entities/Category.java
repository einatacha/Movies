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
@Table(name = "category")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "id", nullable = false)
        private long id;

        @NotNull(message =  "Este campo não pode ser nulo" )
        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "name", nullable = false)
        private String name;

        @NotNull(message =  "Este campo não pode ser nulo" )
        @NotEmpty(message=  "Este campo não pode ser vazio" )
        @Column(name = "language", nullable = false)
        private String language;

        @Column(name = "active")
        private boolean active = true;


        @ManyToOne
        @JoinColumn(name = "language_id")
        private Languages languages;


    }

