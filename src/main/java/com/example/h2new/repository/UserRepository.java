package com.example.h2new.repository;

import com.example.h2new.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    List<User> findByName(String name);
}
