package com.example.springhttpserver.HTTPServer.repository;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import java.util.List;

public interface StringRepository {
    void save(String textId, String messageBody);
    StorageDto findByTextId(String textId);
    void delete(String textId);
    List<StorageDto> findAll();
}
