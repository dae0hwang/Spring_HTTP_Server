package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.service.ResponseService;
import com.example.springhttpserver.HTTPServer.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TextController {
    private final TextService textService;
    private final ResponseService responseService;

    @GetMapping("/api/text/{textId}")
    public ResponseEntity<String> getFromTextAndTextId(@PathVariable String textId) {
        var stringOfTextId = textService.manipulateFromGetAndText1(textId);
        var manipulateStateDto = textService.manipulateFromGetAndText2(stringOfTextId);
        ResponseEntity responseEntity = responseService.responseFromGetAndText(manipulateStateDto, stringOfTextId);
        return responseEntity;
    }

    @PostMapping("/api/text/{textId}")
    public ResponseEntity postFromText(@PathVariable String textId,  @RequestBody String messageBody) {
        var manipulateStateDto = textService.manipulateFromPostAndText(textId, messageBody);
        System.out.println(manipulateStateDto.toString());
        var responseEntity = responseService.responseFromPostAndText(manipulateStateDto);
        System.out.println("StringStorage : " + textService.getStorage().toString());
        return responseEntity;
    }

    @PutMapping("/api/text/{textId}")
    public ResponseEntity putFromText(@PathVariable String textId, @RequestBody String messageBody) {
        var manipulateStateDto = textService.manipulateFromPutAndText(textId, messageBody);
        var responseEntity = responseService.responseFromPutAndText(manipulateStateDto);
        return responseEntity;
    }

    @DeleteMapping("/api/text/{textId}")
    public ResponseEntity deleteFromTextAndTextId(@PathVariable String textId) {
        var manipulateStateDto = textService.manipulateFromDeleteAndText(textId);
        var responseEntity = responseService.responseFromDeleteAndText(manipulateStateDto);
        return responseEntity;
    }
}

