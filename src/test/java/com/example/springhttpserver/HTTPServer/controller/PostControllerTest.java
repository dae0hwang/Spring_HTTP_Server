package com.example.springhttpserver.HTTPServer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PostControllerTest {
    @Autowired
    private PostController postController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void postFromText() throws Exception {
        //given

        //when

        //then1
        mockMvc.perform(MockMvcRequestBuilders.post("/api/text/textId").content("messageBody"))
            .andExpect(status().isCreated())
            .andDo(print());

        //then2
        mockMvc.perform(MockMvcRequestBuilders.post("/api/text/textId"))
            .andExpect(status().isBadRequest())
            .andDo(print());

    }
}