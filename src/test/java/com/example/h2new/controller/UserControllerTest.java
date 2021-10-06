package com.example.h2new.controller;

import com.example.h2new.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsers() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/getAll");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByName() {
    }

    @Test
    void createUserByName() {
    }
}
