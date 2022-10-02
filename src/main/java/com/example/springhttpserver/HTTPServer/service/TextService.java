package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextService {

    private final JdbcStringRepository jdbcStringRepository;

    public ManipulateState manipulateFromPostAndText(String textId, String messageBody) {
        if (textId != null && messageBody != null) {
            jdbcStringRepository.save(textId, messageBody);
            return ManipulateState.SUCCESS;
        } else {
            return ManipulateState.FAIL;
        }
    }

    public String manipulateFromGetAndText1(String textId) {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            return storageDto.getMessageBody();
        } else {
            return null;
        }
    }

    public ManipulateState manipulateFromGetAndText2(String stringOfTextId) {
        if (stringOfTextId != null) {
            return ManipulateState.SUCCESS;
        } else {
            return ManipulateState.FAIL;
        }
    }

    public ManipulateState manipulateFromDeleteAndText(String textId) {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            jdbcStringRepository.delete(textId);
            return ManipulateState.SUCCESS;
        } else {
            return ManipulateState.FAIL;
        }
    }

    public List<StorageDto> getStorage() {
        return jdbcStringRepository.findAll();
    }

    public ManipulateState manipulateFromPutAndText(String textId, String messageBody) {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && messageBody != null && storageDto != null) {
            jdbcStringRepository.update(textId, messageBody);
            return ManipulateState.SUCCESS;
        }
        return ManipulateState.FAIL;
    }
}
