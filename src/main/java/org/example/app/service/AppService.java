package org.example.app.service;

import org.example.app.controller.UserCreateController;
import org.example.app.controller.UserDeleteController;
import org.example.app.controller.UserReadController;
import org.example.app.controller.UserUpdateController;
import org.example.app.exceptions.OptionException;
import org.example.app.repository.UserCreateRepository;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.repository.UserReadRepository;
import org.example.app.repository.UserUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UserCreateView;
import org.example.app.view.UserDeleteView;
import org.example.app.view.UserReadView;
import org.example.app.view.UserUpdateView;

public class AppService {

    public void createInfoUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createInfoUser();
    }

    public void readInfoUser() {
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readInfoUser();
    }

    public void updateInfoUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service, view);
        controller.updateInfoUser();
    }

    public void deleteInfoUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteInfoUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Перевірка наявності опції
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
