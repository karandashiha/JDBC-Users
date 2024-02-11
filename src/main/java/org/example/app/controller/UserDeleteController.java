package org.example.app.controller;

import org.example.app.service.UserDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserDeleteView;

public class UserDeleteController {

    UserDeleteService service;
    UserDeleteView view;

    public UserDeleteController(UserDeleteService service, UserDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteInfoUser() {
        view.getOutput(service.deleteInfoUser(view.getData()));
        AppStarter.startApp();
    }
}
