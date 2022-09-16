package com.example.springhttpserver.HTTPServer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageServiceTest {
    ImageService imageService;

    @BeforeEach
    void init() {
        imageService = new ImageService();
    }
    @Test
    void manipulateFromGetAndImage() throws IOException {
        //given
        ClassPathResource resource = new ClassPathResource("image/sea.jpg");
        byte[] imageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());

        //when
        byte[] expected = imageService.manipulateFromGetAndImage();

        //then
        assertArrayEquals(expected, imageBytes);
    }
}