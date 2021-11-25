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
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "CPF", nullable = false)
    private String CPF;

  //  @Column(name = "profiles")
  //  private String profiles;

    @Column(name = "active")
    private String active;

    @ManyToOne
    private Languages languages;

    @Enumerated(EnumType.STRING)
    private ProfileEnum profile;
    }
