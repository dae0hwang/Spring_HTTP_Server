package com.example.springhttpserver.HTTPServer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springhttpserver.HTTPServer.RepositoryResetHelper;
import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcStringRepositoryTest {

    @Autowired
    JdbcStringRepository repository;
    @Autowired
    RepositoryResetHelper resetHelper;
    Connection connection;

    @BeforeEach
    void beforeEach() throws SQLException {
        repository = Mockito.spy(new JdbcStringRepository());
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc"
            , "root", "111111");
        Mockito.doReturn(connection).when(repository).connectJdbc();

        resetHelper.ifExistDeleteStorage(connection);
        resetHelper.createStorageTable(connection);
    }

    @Test
    @DisplayName("save and findByText Test")
    void save() {
        //given

        //when
        repository.save(connection, "id", "message");
        StorageDto storageDto = repository.findByTextId(connection, "id");

        //then
        assertThat(storageDto.getTextId()).isEqualTo("id");
        assertThat(storageDto.getMessageBody()).isEqualTo("message");
    }


    @Test
    void update() {
        //given
        repository.save(connection, "id", "message");
        //when
        repository.update(connection, "id", "updateMessage");
        //then
        StorageDto findStorage = repository.findByTextId(connection, "id");
        assertThat(findStorage.getTextId()).isEqualTo("id");
        assertThat(findStorage.getMessageBody()).isEqualTo("updateMessage");
    }

    @Test
    void delete() {
        //given
        repository.save(connection, "id", "message");
        //when
        repository.delete(connection, "id");
        //then
        StorageDto findStorage = repository.findByTextId(connection, "id");
        assertThat(findStorage).isNull();
    }
}