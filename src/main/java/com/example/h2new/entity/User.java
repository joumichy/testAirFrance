package com.example.h2new.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getCountryResidence() {
        return countryResidence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public User() {
    }
}
