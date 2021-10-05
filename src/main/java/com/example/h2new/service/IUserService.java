package com.example.h2new.service;

import com.example.h2new.entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findByName(String name);
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User user);
}
