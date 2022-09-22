//package com.example.springhttpserver.HTTPServer.service;
//
//import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.concurrent.ConcurrentHashMap;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TextServiceTest {
//
//    TextService textService;
//
//    @BeforeEach
//    void init() {
//        textService = new TextService();
//    }
//
//    @Test
//    void getStorage() {
//        //given
//        ConcurrentHashMap<String, String> resultStorage = new ConcurrentHashMap<>();
//
//        //when
//        ConcurrentHashMap<String, String> expected = textService.getStorage();
//
//        //then
//        assertTrue(expected.equals(resultStorage));
//    }
//
//    @Disabled
//    @Test
//    void pushString() {
//        //given
//        ConcurrentHashMap<String, String> resultStorage = new ConcurrentHashMap<>();
//        resultStorage.put("id", "string");
//        textService.pushString("id", "string");
//
//        //when
//        ConcurrentHashMap<String, String> expected = textService.getStorage();
//
//        //then
//        assertTrue(expected.equals(resultStorage));
//    }
//
//    @Test
//    void manipulateFromPostAndText() {
//       //given
//        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
//        ManipulateStateDto failResult = ManipulateStateDto.FAIL;
//        String textId = "textId";
//        String messageBody = "messageBody";
//
//        //when1
//        ManipulateStateDto expected1 = textService.manipulateFromPostAndText(textId, messageBody);
//        //then1
//        assertEquals(expected1, successResult);
//
//        //when2
//        ManipulateStateDto expected2 = textService.manipulateFromPostAndText(null, messageBody);
//        //then2
//        assertEquals(expected2, failResult);
//
//        //when3
//        ManipulateStateDto expected3 = textService.manipulateFromPostAndText(textId, null);
//        //then3
//        assertEquals(expected3, failResult);
//
//        //when4
//        ManipulateStateDto expected4 = textService.manipulateFromPostAndText(null, null);
//        //then4
//        assertEquals(expected4, failResult);
//    }
//
//    @Test
//    void manipulateFromGetAndText1() {
//        //given
//        textService.pushString("textId", "messageBody");
//        String result1 = "messageBody";
//
//        //when1
//        String expected1 = textService.manipulateFromGetAndText1("textId");
//        //then1
//        assertTrue(expected1.equals(result1));
//
//        //when2
//        String expected2 = textService.manipulateFromGetAndText1("wrongTextId");
//        //then2
//        assertEquals(expected2, null);
//    }
//
//    @Test
//    void manipulateFromGetAndText2() {
//        //given
//        String StringTextId = "StringTextId";
//        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
//        ManipulateStateDto failResult = ManipulateStateDto.FAIL;
//
//        //when1
//        ManipulateStateDto expected1 = textService.manipulateFromGetAndText2(StringTextId);
//        //then1
//        assertEquals(expected1, successResult);
//
//        //when2
//        ManipulateStateDto expected2 = textService.manipulateFromGetAndText2(null);
//        //then2
//        assertEquals(expected2, failResult);
//    }
//
//    @Test
//    void manipulateFromDeleteAndText() {
//        //given
//        textService.pushString("textId", "messageBody");
//        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
//        ManipulateStateDto failResult = ManipulateStateDto.FAIL;
//
//        //when1
//        ManipulateStateDto expected1 = textService.manipulateFromDeleteAndText("textId");
//        //then1
//        assertEquals(expected1, successResult);
//
//        //when2
//        ManipulateStateDto expected2 = textService.manipulateFromDeleteAndText(null);
//        //then2
//        assertEquals(expected2, failResult);
//
//        //when3
//        ManipulateStateDto expected3 = textService.manipulateFromDeleteAndText("wrongTextId");
//        //given3
//        assertEquals(expected3, failResult);
//    }
//}