package com.example.springhttpserver.HTTPServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RepositoryResetHelper {

    public void ifExistDeleteStorage(Connection connection) {
        String sql = "DROP TABLE IF EXISTS storage";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("error message={}", e.getMessage(), e);
        }
    }

    public void createStorageTable(Connection connection) {
        String sql = "CREATE TABLE storage(\n"
            + "    id BIGINT AUTO_INCREMENT PRIMARY KEY ,\n"
            + "    txt_id VARCHAR(30) NOT NULL UNIQUE ,\n"
            + "    message VARCHAR(80) NOT NULL\n"
            + ")";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("error message={}", e.getMessage(), e);
        }
    }
}
