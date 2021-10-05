package com.example.h2new.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private String name;

    private LocalDate dateNaissance;
    private String countryResidence;

    private String phoneNumber;
    private String gender;

    public User(String name, LocalDate dateNaissance, String countryResidence, String phoneNumber, String gender) {
        this.name = name;
        this.dateNaissance = dateNaissance;
        this.countryResidence = countryResidence;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public User() {
    }
}
