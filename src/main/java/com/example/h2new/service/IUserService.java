package com.example.h2new.service;

import com.example.h2new.entity.User;
import com.example.h2new.entity.UserException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<List<User>> findByName(String name);
    Optional<List<User>> findAll();
    Optional<User> findById(Integer id);
    User save(User user) throws UserException;
}
