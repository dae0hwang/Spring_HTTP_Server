package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TextServiceTest {

    @Autowired
    TextService textService;
    @Autowired
    JdbcStringRepository jdbcStringRepository;

    @BeforeEach
    void beforeEach() {
        jdbcStringRepository.deleteAll();
    }

    @AfterEach
    void afterEach() {
        jdbcStringRepository.delete("textId");
    }

    @Test
    @DisplayName("post 메소드 성공 테스트")
    void manipulateFromPostAndText1() throws NotFoundException {
        //given
        ManipulateState successResult = ManipulateState.SUCCESS;
        String textId = "textId";
        String messageBody = "messageBody";

        //when
        ManipulateState expected1 = textService.manipulateFromPostAndText(textId, messageBody);
        //then
        assertEquals(expected1, successResult);
    }

    @Test
    @DisplayName("post 메소드 실패, textId 없어서")
    void manipulateFromPostAndText2() {
        //given
        String messageBody = "message";

        //then
        assertThrows(NotFoundException.class, () -> {
            //when
            textService.manipulateFromPostAndText(null, messageBody);
        });
    }

    @Test
    @DisplayName("get 메소드 성공 test")
    void manipulateFromGetAndText1() throws NotFoundException {
        //given
        jdbcStringRepository.save("textId", "messageBody");
        String result1 = "messageBody";

        //when
        String expected1 = textService.manipulateFromGetAndText("textId");
        //then
        assertEquals(expected1, result1);
    }

    @Test
    @DisplayName("get 메소드 실패 test")
    void manipulateFromGetAndText2() {
        //given
        jdbcStringRepository.save("textId", "messageBody");

        //then
        assertThrows(NotFoundException.class, () -> {
            //when
            textService.manipulateFromGetAndText("wrongTextId");
        });
    }

    @Test
    @DisplayName("delete 메소드 성공 test")
    void manipulateFromDeleteAndText1() throws NotFoundException {
        //given
        jdbcStringRepository.save("textId", "messageBody");
        ManipulateState successResult = ManipulateState.SUCCESS;

        //when
        ManipulateState expected1 = textService.manipulateFromDeleteAndText("textId");
        //then
        assertEquals(expected1, successResult);
    }

    @Test
    @DisplayName("delete 메소드 실패 test")
    void manipulateFromDeleteAndText2() {
        //given
        jdbcStringRepository.save("textId", "messageBody");

        //then
        assertThrows(NotFoundException.class, () -> {
            //when
            textService.manipulateFromDeleteAndText("wrongTextId");
        });
    }

    @Test
    @DisplayName("post 메소드 성공 test")
    void manipulateFromPutAndText1() throws NotFoundException {
        //given
        jdbcStringRepository.save("textId", "messageBody");
        ManipulateState success = ManipulateState.SUCCESS;

        //when
        ManipulateState expected1 = textService.manipulateFromPutAndText("textId",
            "updateMessage");
        //then
        assertEquals(expected1, success);
    }

    @Test
    @DisplayName("put 메소드 실패 test")
    void manipulateFromPutAndText2() {
        //given
        jdbcStringRepository.save("textId", "messageBody");

        //then
        assertThrows(NotFoundException.class, () -> {
            //when
            textService.manipulateFromPutAndText("noExistId", "updateMessage");
        });
    }
}