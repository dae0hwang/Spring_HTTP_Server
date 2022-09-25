package com.example.springhttpserver.HTTPServer.repository;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStringRepository implements StringRepository{
    private final static ConcurrentHashMap<String, String> stringStorage = new ConcurrentHashMap<>();


    @Override
    public void save(String textId, String messageBody) {
        stringStorage.put(textId, messageBody);
    }

    @Override
    public StorageDto findByTextId(String textId) {
        StorageDto storageDto = new StorageDto();
        String messageBody = stringStorage.get(textId);
        storageDto.setTextId(textId);
        storageDto.setMessageBody(messageBody);
        return storageDto;
    }

    @Override
    public void delete(String textId) {
        stringStorage.remove(textId);
    }

    @Override
    public List<StorageDto> findAll() {
        List<StorageDto> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : stringStorage.entrySet()) {
            StorageDto storageDto = new StorageDto();
            storageDto.setTextId(entry.getKey());
            storageDto.setMessageBody(entry.getValue());
            list.add(storageDto);
        }
        return list;
    }
}
