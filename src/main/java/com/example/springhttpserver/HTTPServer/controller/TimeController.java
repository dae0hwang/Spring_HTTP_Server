package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import com.example.springhttpserver.HTTPServer.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/api/time")
    public ResponseEntity<TimeDto> getFromTime() {
        var timeDto = timeService.getCurrentTime();
        return ResponseEntity.ok()
            .body(timeDto);
    }
}
