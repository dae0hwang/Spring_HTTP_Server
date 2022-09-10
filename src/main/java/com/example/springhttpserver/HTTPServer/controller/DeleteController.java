package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.service.ResponseService;
import com.example.springhttpserver.HTTPServer.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DeleteController {
    private final TextService textService;
    private final ResponseService responseService;

    @DeleteMapping("/api/text/{textId}")
    public ResponseEntity deleteFromTextAndTextId(@PathVariable String textId) {
        var manipulateStateDto = textService.manipulateFromDeleteAndText(textId);
        var responseEntity = responseService.responseFromDeleteAndText(manipulateStateDto);
        return responseEntity;
    }
}
