package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextService {

    private final JdbcStringRepository jdbcStringRepository;

    public ManipulateState manipulateFromPostAndText(String textId, String messageBody)
        throws NotFoundException {
        if (textId != null && messageBody != null) {
            jdbcStringRepository.save(textId, messageBody);
            return ManipulateState.SUCCESS;
        } else {
            throw new NotFoundException();
        }
    }

    public String manipulateFromGetAndText(String textId) throws NotFoundException {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            return storageDto.getMessageBody();
        } else {
            throw new NotFoundException();
        }
    }

    public ManipulateState manipulateFromDeleteAndText(String textId) throws NotFoundException {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && storageDto != null) {
            jdbcStringRepository.delete(textId);
            return ManipulateState.SUCCESS;
        } else {
            throw new NotFoundException();
        }
    }

    public ManipulateState manipulateFromPutAndText(String textId, String messageBody)
        throws NotFoundException {
        StorageDto storageDto = jdbcStringRepository.findByTextId(textId);
        if (textId != null && messageBody != null && storageDto != null) {
            jdbcStringRepository.update(textId, messageBody);
            return ManipulateState.SUCCESS;
        } else {
            throw new NotFoundException();
        }
    }
}
