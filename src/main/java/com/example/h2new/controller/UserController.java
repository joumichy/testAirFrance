package com.example.h2new.controller;

import com.example.h2new.entity.User;
import com.example.h2new.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "API pour les operations CRUD d'un utilisateur")
@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService userService;

    @ApiOperation(value = "Recuperer la liste de tous les utilisateurs")
    @GetMapping("/getAll")
    Optional<List<User>> getAllUsers(){
        return userService.findAll();
    }


    @ApiOperation(value = "Recuperr un utilisateur par ID")
    @GetMapping("/getById/{id}")
    @ResponseBody
    ResponseEntity getUserById(@ApiParam(value = "Int ID", required = true)
                                   @PathVariable("id")  Integer id){

        try{
            Optional<User> user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @ApiOperation(value = "Recuperer un utilisateur par son nom")
    @GetMapping("/getByName/{name}")
    ResponseEntity getUserByName(@ApiParam(value = "String Name", required = true)@PathVariable(name="name") String name){

        try{
            Optional<List<User>> users = userService.findByName(name);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }


    }

    @ApiOperation(value = "Creer un utilisateur")
    @PostMapping("/create")
    ResponseEntity createUserByName(@ApiParam(value = "Model User", required = true )@RequestBody User user){

        try{

            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }


}
