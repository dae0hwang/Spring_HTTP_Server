//package com.example.springhttpserver.HTTPServer.controller;
//
//import com.example.springhttpserver.HTTPServer.service.TextService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//class TextControllerTest {
//    @Autowired
//    private TextController textController;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void init() {
//        mockMvc = MockMvcBuilders.standaloneSetup(textController).build();
//    }
//
//    @Test
//    void getFromTextAndTextId() throws Exception {
//        //given
//        TextService textService = new TextService();
//        textService.pushString("textId", "messageBody");
//
//        //when
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/text/textId"))
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.content().string("messageBody"))
//            .andDo(MockMvcResultHandlers.print());
//
//        //then
//        mockMvc.perform(get("/api/text/wrongTextId"))
//            .andExpect(status().isNotFound())
//            .andDo(print());
//    }
//
//    @Test
//    void postFromText() throws Exception {
//        //given
//
//        //when
//
//        //then
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/text/textId").content("messageBody"))
//            .andExpect(status().isCreated())
//            .andDo(print());
//
//        //then
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/text/textId"))
//            .andExpect(status().isBadRequest())
//            .andDo(print());
//    }
//
//    @Test
//    void deleteFromTextAndTextId() throws Exception {
//        //given
//        TextService textService = new TextService();
//        textService.pushString("textId", "messageBody");
//
//        //when1
//        var request1 = MockMvcRequestBuilders.delete("/api/text/textId");
//
//        //then1
//        mockMvc.perform(request1)
//            .andExpect(status().isNoContent())
//            .andDo(print());
//
//        //when2
//        var request2 = MockMvcRequestBuilders.delete("/api/text/wrongTextId");
//
//        //then2
//        mockMvc.perform(request2)
//            .andExpect(status().isNotFound())
//            .andDo(print());
//    }
//}