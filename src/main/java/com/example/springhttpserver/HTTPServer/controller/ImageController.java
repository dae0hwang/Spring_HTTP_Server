package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/api/image")
    public ResponseEntity<byte[]> getFromImage() throws IOException {
        byte[] imageBytes = imageService.manipulateFromGetAndImage();
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imageBytes);
    }
}
