package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.dto.TimeDto;
import com.example.springhttpserver.HTTPServer.service.ResponseService;
import com.example.springhttpserver.HTTPServer.service.TextService;
import com.example.springhttpserver.HTTPServer.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class GetController {
    private final TimeService timeService;
    private final TextService textService;
    private final ResponseService responseService;

    @GetMapping("/api/time")
    public ResponseEntity<TimeDto> getFromTime() {
        var timeDto = timeService.getCurrentTime();
        return ResponseEntity.ok()
            .body(timeDto);
    }

    @GetMapping("/api/text/{textId}")
    public ResponseEntity<String> getFromTextAndTextId(@PathVariable String textId) {
        var stringOfTextId = textService.manipulateFromGetAndText1(textId);
        var manipulateStateDto = textService.manipulateFromGetAndText2(stringOfTextId);
        ResponseEntity responseEntity = responseService.responseFromGetAndText(manipulateStateDto, stringOfTextId);
        return responseEntity;
    }

//    @GetMapping("/api/image")
//    public ResponseEntity<byte[]> getFromImage() {
//
//    }
}
