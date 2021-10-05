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
    ZoneId defaultZoneId = ZoneId.systemDefault();
    LocalDate localdateUser1= LocalDate.of(1976 ,2,15);
    LocalDate localdateUser2= LocalDate.of(1981 ,10,01);
    LocalDate localdateUser3= LocalDate.of(1985 ,9,26);
    LocalDate localdateUser4= LocalDate.of(1965 ,5,9);

    @Bean
    CommandLineRunner start(UserRepository userRepository){

        return args -> {
            userRepository.save(new User("John", localdateUser1, "France", "0612233663", "Femme"));
            userRepository.save(new User("Nadir Chelbi", localdateUser2, "France", "0645566996", "Homme"));
            userRepository.save(new User( "celine dupond", localdateUser3, "France", "0645566996", "Femme"));
            userRepository.save(new User( "martine Paul", localdateUser4, "France", "0612233663", "Femme"));
            userRepository.findAll().forEach(user -> {
                System.out.println(user.toString());
            });
        };
    }}
