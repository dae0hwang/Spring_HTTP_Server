package com.example.springhttpserver.HTTPServer.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@Service
public class ImageService {

    public byte[] manipulateFromGetAndImage() throws IOException {
        ClassPathResource resource = new ClassPathResource("image/sea.jpg");
        return FileCopyUtils.copyToByteArray(resource.getInputStream());
    }
}
