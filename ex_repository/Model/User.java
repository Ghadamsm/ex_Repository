package com.example.ex_repository.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "name should be not empty")
    @Size(min = 4 , message = "name should be more than 4 char")
    @Column(columnDefinition = "varchar(10) not null")
    private String name ;


    @NotEmpty(message = "username should be not empty")
    @Size(min = 4 , message = "username should be more than 4 char")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username ;


    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password ;


    @NotEmpty(message = "email should be not empty")
    @Email(message = "please enter invalid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email ;


    @NotEmpty(message = "role should be not empty")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(5) not null check(role = 'user' or role = 'admin')")
    private String role ;


    @NotNull(message = "age should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer age ;



}
