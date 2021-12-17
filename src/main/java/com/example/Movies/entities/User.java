package com.example.Movies.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//aprovado
import javax.persistence.UniqueConstraint;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "CPF", name = "users"))

public class User implements  UserDetails{

    private static final long serialVersion=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "id" )
    private Long id;

//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "cellphone")
    private int cellPhone;
//
//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "password") @Length(min = 6)
    private String password;
//
//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode ser vazio" )
    @Column(name = "name")
    private String name;

   @Email
//   @NotNull(message =  "Este campo não pode ser nulo" )
//   @NotEmpty(message  =  "Este campo não pode estar vazio" )
   @Column(name = "email", unique=true)
    private String email;

   @org.hibernate.validator.constraints.br.CPF
//   @NotNull(message =  "Este campo não pode ser nulo" )
//   @NotEmpty(message  =  "Este campo não pode estar vazio" )
   @Column(name = "CPF", nullable = false,unique=true ) @Length(min = 11, max = 11)
    private String cpf;

//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode estar vazio" )
    @Column(name = "profiles")
    private String profiles;
//
//    @NotNull(message =  "Este campo não pode ser nulo" )
//    @NotEmpty(message  =  "Este campo não pode estar vazio" )
    @Column(name = "active" )
    private boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Profile> perfis = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ManyToOne
    @JoinColumn(name = "languages_id")
    private Languages languages;

   
}



