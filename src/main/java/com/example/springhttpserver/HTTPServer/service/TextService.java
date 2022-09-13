package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TextService {
    private final static ConcurrentHashMap<String, String> stringStorage = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, String> getStorage() {
        return TextService.stringStorage;
    }

    public void pushString(String textId, String messageBody) {
        stringStorage.put(textId, messageBody);
    }

    public ManipulateStateDto manipulateFromPostAndText(String textId, String messageBody) {
        if (textId != null && messageBody != null) {
            stringStorage.put(textId, messageBody);
            return ManipulateStateDto.SUCCESS;
        } else {
            return ManipulateStateDto.FAIL;
        }
    }

    public String manipulateFromGetAndText1(String textId) {
        if (textId != null && stringStorage.containsKey(textId)) {
            return stringStorage.get(textId);
        } else {
            return null;
        }
    }

    public ManipulateStateDto manipulateFromGetAndText2(String stringOfTextId) {
        if (stringOfTextId != null) {
            return ManipulateStateDto.SUCCESS;
        } else {
            return ManipulateStateDto.FAIL;
        }
    }

    public ManipulateStateDto manipulateFromDeleteAndText(String textId) {
        if (textId != null && stringStorage.containsKey(textId)) {
            stringStorage.remove(textId);
            return ManipulateStateDto.SUCCESS;
        } else {
            return ManipulateStateDto.FAIL;
        }
    }
}
