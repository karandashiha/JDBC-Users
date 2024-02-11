package org.example.app.service;

import org.example.app.entity.User;
import org.example.app.repository.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {

    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readInfoUser() {

        // Отримуємо дані у колекцію.
        List<User> list = repository.readInfoUser();

        // Якщо колекція не null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (list != null) {
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((info) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(info.getId())
                                .append(", ")
                                .append(info.getFirstName())
                                .append(" ")
                                .append(info.getLastName())
                                .append(", ")
                                .append(info.getEmail())
                                .append("\n")
                );
                return "\n______ CONTACTS ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
