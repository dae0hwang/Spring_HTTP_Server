package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public ResponseEntity responseFromPostAndText(ManipulateStateDto manipulateStateDto) {
        if (manipulateStateDto == ManipulateStateDto.SUCCESS) {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }

    public ResponseEntity responseFromPutAndText(ManipulateStateDto manipulateStateDto) {
        if (manipulateStateDto == ManipulateStateDto.SUCCESS) {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }

    public ResponseEntity<String> responseFromGetAndText
        (ManipulateStateDto manipulateStateDto, String stringOfTextId) {
        if (manipulateStateDto == ManipulateStateDto.SUCCESS) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(stringOfTextId);
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }

    public ResponseEntity responseFromDeleteAndText(ManipulateStateDto manipulateStateDto) {
        if (manipulateStateDto == ManipulateStateDto.SUCCESS) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
