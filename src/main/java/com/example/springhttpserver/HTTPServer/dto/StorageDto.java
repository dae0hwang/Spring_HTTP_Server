package com.example.springhttpserver.HTTPServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StorageDto {

    private String textId;
    private String messageBody;
}
