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
@Table(name = "movies")
public class Movies {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "id", nullable = false)
        private long id;

        @Column(name = "title")
        private String title;

        @Column(name = "categorys", nullable = false)
        private String categorys;

        @Column(columnDefinition = "TEXT")
        private String synopsis;

        @Column(columnDefinition = "TEXT")
        private String image;


        @Column(name = "active")
        private boolean active = true;

        @Column(name = "releasedate")
        private String releaseDate;

        @Column(name = "duration")
        private String duration;



        @ManyToOne
        @JoinColumn(name = "languages_id")
        private Languages languages;


        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;



    }




