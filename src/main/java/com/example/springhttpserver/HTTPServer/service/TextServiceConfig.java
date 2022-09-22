package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import com.example.springhttpserver.HTTPServer.repository.MemoryStringRepository;
import com.example.springhttpserver.HTTPServer.repository.StringRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextServiceConfig {

    @Bean
    public TextService textService() {
        return new TextService(stringRepository());
    }

    @Bean
    public StringRepository stringRepository() {
        return new JdbcStringRepository();
    }
}
