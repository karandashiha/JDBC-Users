package org.example.app.service;

import org.example.app.entity.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repository.UserUpdateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmailValidator;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserUpdateService {

    UserUpdateRepository repository;

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateInfoUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateInfoUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User contact = new User();
        contact.setId(Integer.parseInt(data[0]));
        contact.setEmail(data[1]);
        return contact;
    }
}
