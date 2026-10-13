package com.project.glowweb.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Userlogin")
@Data
public class UserloginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
}