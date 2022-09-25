//package com.example.springhttpserver.HTTPServer.service;
//
//import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
//import com.example.springhttpserver.HTTPServer.repository.StringRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class TextServiceIntegrationTest {
//
//    @Autowired TextService textService;
//    @Autowired StringRepository stringRepository;
//
//    @Test
//    void manipulateFromPostAndText() {
//        //given
//        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
//        ManipulateStateDto fail = ManipulateStateDto.FAIL;
//
//        //when1
//        ManipulateStateDto expected1 = textService.manipulateFromPostAndText("textId", "message");
//        //then1
//        assertEquals(expected1, success);
//    }
//
//    @Test
//    void manipulateFromGetAndText1() {
//    }
//
//    @Test
//    void manipulateFromGetAndText2() {
//    }
//
//    @Test
//    void manipulateFromDeleteAndText() {
//    }
//
//    @Test
//    void getStorage() {
//    }
//}