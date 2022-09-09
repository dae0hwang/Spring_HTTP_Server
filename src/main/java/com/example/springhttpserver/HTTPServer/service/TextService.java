package com.example.springhttpserver.HTTPServer.service;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Data
public class TextService {
    public static ConcurrentHashMap<String, String> textStorage = new ConcurrentHashMap<>();

    public void storeString(String textId, String stringMessage) {
        textStorage.put(textId, stringMessage);
    }



}
