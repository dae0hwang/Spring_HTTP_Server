package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import com.example.springhttpserver.HTTPServer.service.ResponseService;
import com.example.springhttpserver.HTTPServer.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final TextService textService;
    private final ResponseService responseService;

    @PostMapping("/api/text/{textId}")
    public ResponseEntity postFromText(@PathVariable String textId, @RequestBody String messageBody) {
        ManipulateStateDto manipulateStateDto = textService.manipulateFromPostAndText(textId, messageBody);
        var responseEntity = responseService.responseFromPostAndText(manipulateStateDto);
        log.info("current storage = {}", textService.getStorage());
        return responseEntity;
        //messageBody 비면 400 Bad Request뜨는 것 check
        //남은 것 get image하는 것 남은듯.
    }
}
