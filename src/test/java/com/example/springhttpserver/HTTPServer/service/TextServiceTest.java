package com.example.springhttpserver.HTTPServer.service;

import com.example.springhttpserver.HTTPServer.RepositoryResetHelper;
import com.example.springhttpserver.HTTPServer.dto.ManipulateState;
import com.example.springhttpserver.HTTPServer.exeption.NotFoundException;
import com.example.springhttpserver.HTTPServer.repository.JdbcStringRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TextServiceTest {

    @Autowired
    TextService textService;
    @Autowired
    RepositoryResetHelper resetHelper;
    JdbcStringRepository repository;
    Connection connection;

    @BeforeEach
    void beforeEach() throws SQLException {
        repository = Mockito.spy(new JdbcStringRepository());
        connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test"
            , "sa", "");
        Mockito.doReturn(connection).when(repository).connectJdbc();
        textService = new TextService(repository);

        resetHelper.ifExistDeleteStorage(connection);
        resetHelper.createStorageTable(connection);
    }

    @Test
    @DisplayName("post 메소드 성공 테스트")
    void manipulateFromPostAndText1() throws NotFoundException, SQLException {
        //given
        ManipulateState successResult = ManipulateState.SUCCESS;
        String textId = "textId";
        String messageBody = "messageBody";

        //when
        ManipulateState expected1 = textService.manipulateFromPostAndText(textId, messageBody);
        //then
        assertThat(expected1).isEqualTo(successResult);
    }

    @Test
    @DisplayName("post 메소드 실패, textId 없어서")
    void manipulateFromPostAndText2() throws SQLException {
        //given
        String messageBody = "message";

        //then
        assertThatThrownBy(() -> {
            textService.manipulateFromPostAndText(null, messageBody);
        })
            .isInstanceOf(NotFoundException.class);
    }

    @Test
    @DisplayName("get 메소드 성공 test")
    void manipulateFromGetAndText1() throws NotFoundException, SQLException {
        //given
        repository.save(connection, "textId", "messageBody");
        String result = "messageBody";

        //when
        String expected = textService.manipulateFromGetAndText("textId");
        //then
        assertThat(expected).isEqualTo(result);
    }

    @Test
    @DisplayName("get 메소드 실패 test")
    void manipulateFromGetAndText2() throws SQLException {
        //given
        repository.save(connection, "textId", "messageBody");

        //then
        assertThatThrownBy(() -> {
            textService.manipulateFromGetAndText("wrongTextId");
        })
            .isInstanceOf(NotFoundException.class);
    }

    @Test
    @DisplayName("delete 메소드 성공 test")
    void manipulateFromDeleteAndText1() throws NotFoundException, SQLException {
        //given
        repository.save(connection, "textId", "messageBody");
        ManipulateState successResult = ManipulateState.SUCCESS;

        //when
        ManipulateState expected = textService.manipulateFromDeleteAndText("textId");
        //then
        assertThat(expected).isEqualTo(successResult);
    }

    @Test
    @DisplayName("delete 메소드 실패 test")
    void manipulateFromDeleteAndText2() {
        //given
        repository.save(connection, "textId", "messageBody");

        //then
        assertThatThrownBy(() -> {
            textService.manipulateFromDeleteAndText("wrongText");
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    @DisplayName("post 메소드 성공 test")
    void manipulateFromPutAndText1() throws NotFoundException, SQLException {
        //given
        repository.save(connection, "textId", "messageBody");
        ManipulateState success = ManipulateState.SUCCESS;

        //when
        ManipulateState expected1 = textService.manipulateFromPutAndText("textId",
            "updateMessage");
        //then
        assertThat(expected1).isEqualTo(success);
    }

    @Test
    @DisplayName("put 메소드 실패 test")
    void manipulateFromPutAndText2() {
        //given
        repository.save(connection, "textId", "messageBody");

        //then
        assertThatThrownBy(() -> {
            textService.manipulateFromPutAndText("noExistId", "updateMessage");
        }).isInstanceOf(NotFoundException.class);
    }
}