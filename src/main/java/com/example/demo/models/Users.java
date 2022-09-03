package com.example.demo.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
@Table (name = "user_hakaton")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column (name = "first_name")
    String name;

    @Column (name = "lastname")
    String lastname;

    @Column (name = "email")
    String email;

    @Column (name = "password")
    String password;

    @Column(name = "role")
    String role;
}
