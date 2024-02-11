package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.User;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactReadRepository {

    List<User> list;

    public List<User> readContacts() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, firstName, lastName, email FROM " + Constants.TABLE_USERS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new User(
                                rs.getInt("id"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getString("email")
                        )
                );
            }
            // Повертаємо колекцію даних
            return list;
        } catch (SQLException e) {
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}
