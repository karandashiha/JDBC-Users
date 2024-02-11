package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDeleteRepository {

    public String deleteContact(User contact) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(contact.getId())) {
            return deleteContactById(contact);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String deleteContactById(User contact) {

        String sql = "DELETE FROM " + Constants.TABLE_USERS + " WHERE id = ?";

        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            stmt.setInt(1, contact.getId());
            stmt.executeUpdate();
            return Constants.DATA_DELETE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
