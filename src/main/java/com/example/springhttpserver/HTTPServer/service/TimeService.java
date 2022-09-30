package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TimeService {

    public TimeDto getCurrentTime() {
        TimeDto timeDto = new TimeDto();
        timeDto.setTime((new Date()).toString());
        return timeDto;
    }
}
