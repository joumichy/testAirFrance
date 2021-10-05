package com.example.h2new.service;

import com.example.h2new.entity.User;
import com.example.h2new.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        try{
           users  = userRepository.findByName(name);
           return users;
        }catch (Exception e){
          return users;
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try{
            users  = userRepository.findAll();
            return users;
        }catch (Exception e){
            return users;
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user = Optional.empty();
        try{
            user  = userRepository.findById(id);
            return user;
        }catch (Exception e){
            return user;
        }
    }

    @Override
    public User save(User user) {
        try{
            user = userRepository.save(user);
            return  user;

        }catch (Exception e){
            return null;
        }

    }
}
