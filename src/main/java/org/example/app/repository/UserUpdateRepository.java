package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateRepository {

    public String updateInfoUser(User info) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(info.getId())) {
            return updateContactById(info);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateContactById(User contact) {

        String sql = "UPDATE " + Constants.TABLE_USERS + " SET phone = ? WHERE id = ?";
        // PreparedStatement - підготовлений вираз, щоб уникнути SQL-ін'єкцій
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, contact.getEmail());
            pstmt.setInt(2, contact.getId());
            pstmt.executeUpdate();
            return Constants.DATA_UPDATE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
