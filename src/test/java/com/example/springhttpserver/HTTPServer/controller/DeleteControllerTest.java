package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.service.TextService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteControllerTest {
    @Autowired
    private DeleteController deleteController;
    private MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(deleteController).build();
        objectMapper = new ObjectMapper();
    }
    @Test
    void deleteFromTextAndTextId() throws Exception {
        //given
        TextService textService = new TextService();
        textService.pushString("textId", "messageBody");

        //when1
        var request1 = MockMvcRequestBuilders.delete("/api/text/textId");

        //then1
        mockMvc.perform(request1)
            .andExpect(status().isNoContent())
            .andDo(print());

        //when2
        var request2 = MockMvcRequestBuilders.delete("/api/text/wrongTextId");

        //then2
        mockMvc.perform(request2)
            .andExpect(status().isNotFound())
            .andDo(print());
    }
}