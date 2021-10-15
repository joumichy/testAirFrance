package com.example.h2new.controller;

import com.example.h2new.entity.User;
import com.example.h2new.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    Optional<List<User>> getAllUsers(){
        return userService.findAll();
    }


    @GetMapping("/getById/{id}")
    @ResponseBody
    ResponseEntity getUserById(@PathVariable("id")  Integer id){

        try{
            Optional<User> user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @GetMapping("/getByName/{name}")
    ResponseEntity getUserByName(@PathVariable(name="name") String name){

        try{
            Optional<List<User>> users = userService.findByName(name);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }


    }

    @PostMapping("/create")
    ResponseEntity createUserByName(@RequestBody User user){

        try{

            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }


}
