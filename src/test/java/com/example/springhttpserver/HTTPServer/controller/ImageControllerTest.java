package com.example.springhttpserver.HTTPServer.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImageControllerTest {

    @Autowired
    private ImageController imageController;
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }

    @Test
    void getFromImage() throws Exception {
        //given
        ClassPathResource resource = new ClassPathResource("image/sea.jpg");
        byte[] imageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());

        //when

        //then
        mockMvc.perform(get("/api/image"))
            .andExpect(status().isOk())
            .andExpect(content().bytes(imageBytes))
            .andExpect(header().string("Content-Type", "image/jpeg"))
            .andExpect(header().string("Content-Length", "48748"))
            .andDo(print());
    }
}