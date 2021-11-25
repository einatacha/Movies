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
@Table(name = "language")

public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "tag", nullable = false)
    private int tag;


    @OneToMany
    private Movies movies;

    @OneToMany
    private Category category;


}
