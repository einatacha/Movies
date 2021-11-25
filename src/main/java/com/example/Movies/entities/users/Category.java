package com.example.Movies.entities.users;

import com.example.Movies.enums.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
        private int id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "language")
        private String language;

        @Column(name = "active")
        private String active;


        @OneToMany
        private Movies movies;

        @ManyToOne Languages languages;

    }

