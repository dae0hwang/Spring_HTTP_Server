package com.example.springhttpserver.HTTPServer.repository;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcStringRepository {

    public void save(String textId, String messageBody) {
        String sql = "INSERT INTO storage (id, message) VALUES(?,?)";
        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, textId);
            preparedStatement.setString(2, messageBody);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String textId, String messageBody) {
        String sql = "UPDATE storage SET message=? WHERE id=?";
        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, messageBody);
            preparedStatement.setString(2, textId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StorageDto findByTextId(String textId) {
        String sql = "SELECT * FROM storage WHERE id=?";
        StorageDto storageDto = null;

        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, textId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    String id = resultSet.getString(2);
                    String message = resultSet.getString(3);
                    storageDto = new StorageDto();
                    storageDto.setTextId(id);
                    storageDto.setMessageBody(message);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storageDto;
    }

    public void delete(String textId) {
        String sql = "DELETE FROM storage WHERE id=?";

        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, textId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StorageDto> findAll() {
        String sql = "SELECT * FROM storage";
        List<StorageDto> list = new ArrayList<>();

        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    String id = resultSet.getString(2);
                    String message = resultSet.getString(3);
                    StorageDto storageDto = new StorageDto();
                    storageDto = new StorageDto();
                    storageDto.setTextId(id);
                    storageDto.setMessageBody(message);
                    list.add(storageDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteAll() {
        String sql = "DELETE FROM storage";
        try (Connection connection = connectJdbc();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connectJdbc() throws SQLException {
        String server = "localhost:3307";
        String database = "jdbc";
        String user_name = "root";
        String password = "111111";
        return DriverManager.getConnection(
            "jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
    }
}
