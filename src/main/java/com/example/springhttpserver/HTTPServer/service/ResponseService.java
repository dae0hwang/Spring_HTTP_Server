package com.example.springhttpserver.HTTPServer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public ResponseEntity responseFromPostAndText(ManipulateState manipulateState) {
        if (manipulateState == ManipulateState.SUCCESS) {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }

    public ResponseEntity responseFromPutAndText(ManipulateState manipulateState) {
        if (manipulateState == ManipulateState.SUCCESS) {
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
        (ManipulateState manipulateState, String stringOfTextId) {
        if (manipulateState == ManipulateState.SUCCESS) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(stringOfTextId);
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }

    public ResponseEntity responseFromDeleteAndText(ManipulateState manipulateState) {
        if (manipulateState == ManipulateState.SUCCESS) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
