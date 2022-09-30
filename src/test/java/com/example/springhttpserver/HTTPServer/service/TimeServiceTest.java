package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeServiceTest {

    TimeService timeService;

    @BeforeEach
    void init() {
        timeService = new TimeService();
    }

    @Test
    void getCurrentTime() {
        //given
        TimeDto timeDto = new TimeDto();
        timeDto.setTime(new Date().toString());

        //when
        TimeDto expected = timeService.getCurrentTime();

        //then
        assertEquals(expected, timeDto);
    }
}