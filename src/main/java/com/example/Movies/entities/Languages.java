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
@Table(name = "language")

public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "id", nullable = false)
    private int id;

//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "tag", nullable = false)
    private String tag;





}
