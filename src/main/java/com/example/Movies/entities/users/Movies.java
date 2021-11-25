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
@Table(name = "movies")
public class Movies {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "id", nullable = false)
        private int id;

        @Column(name = "title")
        private String title;

        @Column(name = "synopsis")
        private String synopsis;

        @Column(name = "categorys", nullable = false)
        private String categorys;

        @Column(name = "image")
        private String image;

        @Column(name = "active", nullable = true )
        private String active;

        @Column(name = "release date")
        private String releaseDate;

        @Column(name = "duration")
        private String duration;

        @ManyToOne
        private Category category;

        @ManyToOne
        private Languages languages;


    }




