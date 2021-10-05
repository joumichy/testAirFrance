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
    List<User> getAllUsers(){
        return userService.findAll();
    }


    @GetMapping("/getById/{id}")
    @ResponseBody
    Optional<User> getUserById(@PathVariable("id")  Integer id){
        return userService.findById(id);
    }

    @GetMapping("/getByName/{name}")
    ResponseEntity<List<User>> getUserByName(@PathVariable(name="name") String name){

        try{
            List<User> users = userService.findByName(name);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }


    }

    @PostMapping("/create")
    ResponseEntity<User> createUserByName(@RequestBody User user){

        try{

            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

        }
    }


}
