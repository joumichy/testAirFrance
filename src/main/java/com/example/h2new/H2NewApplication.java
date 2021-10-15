package com.example.h2new;


import com.example.h2new.entity.User;
import com.example.h2new.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.ZoneId;

@SpringBootApplication
public class H2NewApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2NewApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository){

        return args -> {

        };
    }}
