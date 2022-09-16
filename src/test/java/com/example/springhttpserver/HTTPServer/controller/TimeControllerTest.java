package com.example.springhttpserver.HTTPServer.controller;

import org.junit.jupiter.api.Test;
import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import com.example.springhttpserver.HTTPServer.service.TimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class TimeControllerTest {
    @Autowired
    private TimeController timeController;
    private MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(timeController).build();
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
}