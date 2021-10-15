package com.example.h2new.service;

import com.example.h2new.entity.User;
import com.example.h2new.entity.UserException;
import com.example.h2new.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void initDB(){

        LocalDate localdateUser1= LocalDate.of(1976 ,2,15);
        LocalDate localdateUser2= LocalDate.of(1981 ,10,01);
        LocalDate localdateUser3= LocalDate.of(1985 ,9,26);
        LocalDate localdateUser4= LocalDate.of(1965 ,5,9);

        userRepository.save(new User("John", localdateUser1, "France", "0612233663", "Homme"));
        userRepository.save(new User("Nadir Chelbi", localdateUser2, "France", "0645566996", "Homme"));
        userRepository.save(new User( "celine dupond", localdateUser3, "France", "0645566996", "Femme"));
        userRepository.save(new User( "martine Paul", localdateUser4, "France", "0612233663", "Femme"));
        userRepository.findAll().forEach(user -> {
            System.out.println(user.toString());
        });

    }
    public void verificationOf(User user) throws UserException{
        LocalDate majority = LocalDate.now();

        if(majority.minusYears(user.getDateNaissance().getYear()).getYear() <= 18) throw new UserException("L'utilisateur n'est pas majeur");

        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(user.getPhoneNumber());

        if(!matcher.matches()) throw new UserException("Numéro de téléphone non valide");



    }
    @Override
    public Optional<List<User>> findByName(String name) {
        List<User> users = new ArrayList<>();
        try{
           users  = userRepository.findByName(name);
           return Optional.of(users);
        }catch (Exception e){
          return Optional.of(users);
        }
    }

    @Override
    public Optional<List<User>> findAll() {
        List<User> users = new ArrayList<>();
        try{
            users  = userRepository.findAll();
            return Optional.of(users);
        }catch (Exception e){
            return Optional.of(users);
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
    public User save(User user) throws UserException  {
        verificationOf(user);
        user = userRepository.save(user);
        return  user;
    }


}
