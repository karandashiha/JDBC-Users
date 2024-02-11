package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.User;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCreateRepository {

    public String createInfoUser(User info) {

        String sql = "INSERT INTO " + Constants.TABLE_USERS +
                " (firstName, lastName, email) VALUES(?, ?, ?)";
        // PreparedStatement - підготовлений вираз, щоб уникнути SQL-ін'єкцій
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, info.getFirstName());
            pstmt.setString(2, info.getLastName());
            pstmt.setString(3, info.getEmail());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
