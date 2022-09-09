package com.example.springhttpserver.HTTPServer.controller;

import com.example.springhttpserver.HTTPServer.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TextController {
    private final TextService textService;

    @PostMapping("api/text/{textId}")
    public void postText(@PathVariable String textId, @RequestBody String messageBody) {
        //put 받아왓지 text인거 확인했지. textid인거 확인했지
        //이게 뭐해야 하나. textid에 따라서 처리 성고 실패 여부 이넘 발송하고
        //성공실패 이넘따라서, 그거 리스폰스 메세지 보내기.
        textService.storeString(textId, messageBody);
    }

}
