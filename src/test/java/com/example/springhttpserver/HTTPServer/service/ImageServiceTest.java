package com.example.springhttpserver.HTTPServer.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

@SpringBootTest
class ImageServiceTest {

    @Autowired
    ImageService imageService;

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