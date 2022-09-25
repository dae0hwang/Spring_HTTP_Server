package com.example.springhttpserver.HTTPServer.repository;

import com.example.springhttpserver.HTTPServer.dto.StorageDto;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcStringRepository {

    public void save(String textId, String messageBody) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String server = "localhost:3307";
        String database = "jdbc";
        String user_name = "root";
        String password = "111111";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
            String sql = "INSERT INTO storage VALUES(?,?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, textId);
            pstmt.setString(2, messageBody);
            int count = pstmt.executeUpdate();
            if (count == 0) {
                System.out.println("데이터 입력 실패");
            } else {
                System.out.println("데이터 입력성공");
            }
        } catch (SQLException e) {
            System.out.println("에러 " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public StorageDto findByTextId(String textId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String server = "localhost:3307";
        String database = "jdbc";
        String user_name = "root";
        String password = "111111";
        StorageDto storageDto = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
            String sql = "SELECT * FROM storage WHERE id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, textId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String message = rs.getString(2);
                storageDto = new StorageDto();
                storageDto.setTextId(id);
                storageDto.setMessageBody(message);
            }
        } catch (SQLException e) {
            System.out.println("에러 " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return storageDto;
    }

    public void delete(String textId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String server = "localhost:3307";
        String database = "jdbc";
        String user_name = "root";
        String password = "111111";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            String sql = "DELETE FROM storage WHERE id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, textId);
            int count = pstmt.executeUpdate();
            if (count == 0) {
                System.out.println("데이터 입력 실패");
            } else {
                System.out.println("데이터 입력성공");
            }
        } catch (SQLException e) {
            System.out.println("에러 " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<StorageDto> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String server = "localhost:3307";
        String database = "jdbc";
        String user_name = "root";
        String password = "111111";
        StorageDto storageDto = null;
        List<StorageDto> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            String sql = "SELECT * FROM storage;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String message = rs.getString(2);
                storageDto = new StorageDto();
                storageDto.setTextId(id);
                storageDto.setMessageBody(message);
                list.add(storageDto);
            }
        } catch (SQLException e) {
            System.out.println("에러 " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
