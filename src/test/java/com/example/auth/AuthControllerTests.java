package com.example.auth;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest()//controllers = AuthController.class)
@ExtendWith(SpringExtension.class)
public class AuthControllerTests {
    //In Order to send requests to the controllers
    @Autowired
    MockMvc mockMvc;


}
