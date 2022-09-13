package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import com.example.springhttpserver.HTTPServer.service.TextService;
import com.example.springhttpserver.HTTPServer.service.TimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class GetControllerTest {

    @Autowired
    private GetController getController;
    private MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    void getFromTime() throws Exception {
        //given
        TimeService timeService = new TimeService();
        TimeDto timeDto = timeService.getCurrentTime();
        String json = objectMapper.writeValueAsString(timeDto);

        //when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/time"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(json))
            .andDo(MockMvcResultHandlers.print());
    }


    @Test
    void getFromTextAndTextId() throws Exception {
        //given
        TextService textService = new TextService();
        textService.pushString("textId", "messageBody");

        //when

        //then1
        mockMvc.perform(MockMvcRequestBuilders.get("/api/text/textId"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("messageBody"))
            .andDo(MockMvcResultHandlers.print());

        //then2
        mockMvc.perform(get("/api/text/wrongTextId"))
            .andExpect(status().isNotFound())
            .andDo(print());
    }
}