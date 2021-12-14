package com.example.Movies.entities;

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
        private long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "language")
        private String language;

        @Column(name = "active")
        private boolean active = true;


        @ManyToOne
        @JoinColumn(name = "language_id")
        private Languages languages;


    }

