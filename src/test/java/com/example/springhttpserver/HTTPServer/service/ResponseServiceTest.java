package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponseServiceTest {

    ResponseService responseService;

    @BeforeEach
    void init() {
        responseService = new ResponseService();
    }

    @Test
    void responseFromPostAndText() {
        //given
        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
        ManipulateStateDto fail = ManipulateStateDto.FAIL;

        ResponseEntity<Object> successResult = ResponseEntity.status(HttpStatus.CREATED).body(null);
        ResponseEntity<Object> failResult = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        //when1
        ResponseEntity expected1 = responseService.responseFromPostAndText(success);
        //then1
        assertTrue(expected1.equals(successResult));

        //when2
        ResponseEntity expected2 = responseService.responseFromPostAndText(fail);
        //then2
        assertTrue(expected2.equals(failResult));

    }

    @Test
    void responseFromPutAndText() {
        //given
        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
        ManipulateStateDto fail = ManipulateStateDto.FAIL;

        ResponseEntity<Object> successResult = ResponseEntity.status(HttpStatus.CREATED).body(null);
        ResponseEntity<Object> failResult = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        //when1
        ResponseEntity expected1 = responseService.responseFromPutAndText(success);
        //then1
        assertTrue(expected1.equals(successResult));

        //when2
        ResponseEntity expected2 = responseService.responseFromPutAndText(fail);
        //then2
        assertTrue(expected2.equals(failResult));
    }

    @Test
    void responseFromGetAndText() {
        //given
        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
        ManipulateStateDto fail = ManipulateStateDto.FAIL;

        String stringOfTextId = "stringMessage";
        ResponseEntity<Object> successResult = ResponseEntity.status(HttpStatus.OK).body("stringMessage");
        ResponseEntity<Object> failResult = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        //when1
        ResponseEntity expected1 = responseService.responseFromGetAndText(success, stringOfTextId);
        //then1
        assertTrue(expected1.equals(successResult));

        //when2
        ResponseEntity expected2 = responseService.responseFromGetAndText(fail, stringOfTextId);
        //then2
        assertTrue(expected2.equals(failResult));

    }

    @Test
    void responseFromDeleteAndText() {
        //given
        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
        ManipulateStateDto fail = ManipulateStateDto.FAIL;

        ResponseEntity<Object> successResult = ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        ResponseEntity<Object> failResult = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        //when1
        ResponseEntity expected1 = responseService.responseFromDeleteAndText(success);
        //then1
        assertTrue(expected1.equals(successResult));

        //when2
        ResponseEntity expected2 = responseService.responseFromDeleteAndText(fail);
        //then2
        assertTrue(expected2.equals(failResult));
    }
}