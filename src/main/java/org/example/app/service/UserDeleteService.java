package org.example.app.service;

import org.example.app.entity.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteService {

    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteInfoUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteInfoUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User info = new User();
        info.setId(Integer.parseInt(data[0]));
        return info;
    }
}
