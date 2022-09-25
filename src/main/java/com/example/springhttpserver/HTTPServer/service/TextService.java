package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.ManipulateStateDto;
import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import com.example.springhttpserver.HTTPServer.repository.StringRepository;
import java.util.List;

public class TextService {
    private final StringRepository stringRepository;

    public TextService(StringRepository stringRepository) {
        this.stringRepository = stringRepository;
    }

    public ManipulateStateDto manipulateFromPostAndText(String textId, String messageBody) {
        if (textId != null && messageBody != null) {
            stringRepository.save(textId, messageBody);
            return ManipulateStateDto.SUCCESS;
        } else {
            return ManipulateStateDto.FAIL;
        }
    }

    public String manipulateFromGetAndText1(String textId) {
        StorageDto storageDto = stringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            String message = storageDto.getMessageBody();
            return message;
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
        StorageDto storageDto = stringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            stringRepository.delete(textId);
            return ManipulateStateDto.SUCCESS;
        } else {
            return ManipulateStateDto.FAIL;
        }
    }

    public List<StorageDto> getStorage() {
        List<StorageDto> list = stringRepository.findAll();
        return list;
    }
}
