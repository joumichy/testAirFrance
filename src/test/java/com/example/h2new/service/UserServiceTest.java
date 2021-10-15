package com.example.h2new.service;

import com.example.h2new.controller.UserController;
import com.example.h2new.entity.User;
import com.example.h2new.entity.UserException;
import com.example.h2new.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {



    private  static UserRepository userRepository = mock(UserRepository.class);
    private static UserService userService = mock(UserService.class);

    private  static User user = null;
    private  static User user2 = null;
    private  static User userPhoneError = null;
    private  static User userAgeError = null;
    private  static User userBadGender = null;
    private static LocalDate localDateUser= null;
    private static LocalDate localDateUserMinor= null;
    private static List<User> users = new ArrayList<>();

    private  final String ERROR_AGE_MESSAGE = "L'utilisateur n'est pas majeur";
    private  final String ERROR_PHONE_MESSAGE = "Numéro de téléphone invalide";
    private  final String ERROR_GENDER_MESSAGE = "Genre non valide";
    private  final String ERROR_USERNOTFOUND_MESSAGE = "Utilisateur introuvable";


    @BeforeEach
    void setUp() throws UserException {

        //GIVEN
      localDateUser = LocalDate.of(1976 ,2,15);
      localDateUserMinor = LocalDate.of(2007 ,2,15);
      user = new User("Joe", localDateUser, "France", "0601020304", "Homme");
      user2 = new User("Tom", localDateUser, "Suisse", "0601020304", "Homme");
      userAgeError = new User("Tom", localDateUserMinor, "Suisse", "0601020304", "Homme");
      userPhoneError = new User("Tom", localDateUser, "Suisse", "0101", "Homme");
      userBadGender = new User("Tom", localDateUser, "Suisse", "0101", "Cacahuete");

      users.add(user);
      users.add(user2);

      when(userRepository.findAll()).thenReturn(users);
      when(userRepository.findByName(user.getName())).thenReturn(users);
      when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
      when(userRepository.save(user)).thenReturn(user);



    }

    @Test
    void findByName() throws UserException {
        when(userService.findByName("oiseau")).thenThrow(new UserException(ERROR_USERNOTFOUND_MESSAGE));


        List<User> newUser = userRepository.findByName(user.getName());

        assertNotNull(newUser.get(0));

        assertEquals(user, newUser.get(0));

        assertThrows(UserException.class, () -> userService.findByName("oiseau"));

    }

    @Test
    void findAll() {

        List<User> newUsers = userRepository.findAll();

        assertNotNull(newUsers.get(0));

        assertEquals(user, newUsers.get(0));
        assertEquals(user2, newUsers.get(1));
    }

    @Test
    void findById() throws UserException {

        when(userService.findById(10)).thenThrow(new UserException(ERROR_PHONE_MESSAGE));

        Optional<User> newUser = userRepository.findById(user.getId());

        assertNotNull(newUser.get());

        assertEquals(user, newUser.get());

        assertThrows(UserException.class, () -> userService.findById(10));

    }

    @Test
    void save() throws UserException {

        when(userService.save(userAgeError)).thenThrow(new UserException(ERROR_AGE_MESSAGE));
        when(userService.save(userPhoneError)).thenThrow(new UserException(ERROR_PHONE_MESSAGE));
        when(userService.save(userBadGender)).thenThrow(new UserException(ERROR_GENDER_MESSAGE));

        User newUser = userRepository.save(user);

        assertNotNull(newUser);
        assertEquals(user, newUser);

        assertThrows(UserException.class, () -> userService.save(userAgeError));
        assertThrows(UserException.class, () -> userService.save(userPhoneError));
        assertThrows(UserException.class, () -> userService.save(userBadGender));


    }


}
