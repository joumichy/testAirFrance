package com.example.h2new;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class H2NewApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2NewApplication.class, args);
    }
}


