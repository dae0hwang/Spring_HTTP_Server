package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TextServiceTest {

    @Autowired TextService textService;
    @Autowired JdbcStringRepository jdbcStringRepository;

    @BeforeEach
    void beforeEach() {
        jdbcStringRepository.deleteAll();
    }

    @AfterEach
    void afterEach() {
        jdbcStringRepository.delete("textId");
        jdbcStringRepository.delete("textId1");
        jdbcStringRepository.delete("textId2");
    }

    @Test
    void manipulateFromPostAndText() {
       //given
        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
        ManipulateStateDto failResult = ManipulateStateDto.FAIL;
        String textId = "textId";
        String messageBody = "messageBody";

        //when1
        ManipulateStateDto expected1 = textService.manipulateFromPostAndText(textId, messageBody);
        //then1
        assertEquals(expected1, successResult);

        //when2
        ManipulateStateDto expected2 = textService.manipulateFromPostAndText(null, messageBody);
        //then2
        assertEquals(expected2, failResult);

        //when3
        ManipulateStateDto expected3 = textService.manipulateFromPostAndText(textId, null);
        //then3
        assertEquals(expected3, failResult);

        //when4
        ManipulateStateDto expected4 = textService.manipulateFromPostAndText(null, null);
        //then4
        assertEquals(expected4, failResult);
    }

    @Test
    void manipulateFromGetAndText1() {
        //given
        jdbcStringRepository.save("textId", "messageBody");
        String result1 = "messageBody";

        //when1
        String expected1 = textService.manipulateFromGetAndText1("textId");
        //then1
        assertTrue(expected1.equals(result1));

        //when2
        String expected2 = textService.manipulateFromGetAndText1("wrongTextId");
        //then2
        assertEquals(expected2, null);
    }

    @Test
    void manipulateFromGetAndText2() {
        //given
        String StringTextId = "StringTextId";
        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
        ManipulateStateDto failResult = ManipulateStateDto.FAIL;

        //when1
        ManipulateStateDto expected1 = textService.manipulateFromGetAndText2(StringTextId);
        //then1
        assertEquals(expected1, successResult);

        //when2
        ManipulateStateDto expected2 = textService.manipulateFromGetAndText2(null);
        //then2
        assertEquals(expected2, failResult);
    }

    @Test
    void manipulateFromDeleteAndText() {
        //given
        jdbcStringRepository.save("textId","messageBody");
        ManipulateStateDto successResult = ManipulateStateDto.SUCCESS;
        ManipulateStateDto failResult = ManipulateStateDto.FAIL;

        //when1
        ManipulateStateDto expected1 = textService.manipulateFromDeleteAndText("textId");
        //then1
        assertEquals(expected1, successResult);

        //when2
        ManipulateStateDto expected2 = textService.manipulateFromDeleteAndText(null);
        //then2
        assertEquals(expected2, failResult);

        //when3
        ManipulateStateDto expected3 = textService.manipulateFromDeleteAndText("wrongTextId");
        //given3
        assertEquals(expected3, failResult);
    }

    @Test
    void getStorage() {
        //given
        jdbcStringRepository.save("textId1","messageBody");
        jdbcStringRepository.save("textId2","messageBody");
        List<StorageDto> result = new ArrayList<>();
        StorageDto storageDto1 = new StorageDto();
        storageDto1.setTextId("textId1");
        storageDto1.setMessageBody("messageBody");
        StorageDto storageDto2 = new StorageDto();
        storageDto2.setTextId("textId2");
        storageDto2.setMessageBody("messageBody");
        result.add(storageDto1);
        result.add(storageDto2);

        //when
        List<StorageDto> expectedList = textService.getStorage();

        //then
        assertEquals(expectedList.toString(), result.toString());
    }

    @Test
    void manipulateFromPutAndText() {
        //given
        jdbcStringRepository.save("textId", "messageBody");
        ManipulateStateDto success = ManipulateStateDto.SUCCESS;
        ManipulateStateDto fail = ManipulateStateDto.FAIL;

        //when1
        ManipulateStateDto expected1 = textService.manipulateFromPutAndText("textId", "updateMessage");
        //then1
        assertEquals(expected1, success);

        //when2
        ManipulateStateDto expected2 = textService.manipulateFromPutAndText("noExistId", "updateMessage");
        //then2
        assertEquals(expected2, fail);

        //when3
        ManipulateStateDto expected3 = textService.manipulateFromPutAndText("textId", null);
        //then3
        assertEquals(expected3, fail);

        //when4
        ManipulateStateDto expected4 = textService.manipulateFromPutAndText(null, "updateMessage");
        //then4
        assertEquals(expected4, fail);
    }
}