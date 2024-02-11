package org.example.app.controller;

import org.example.app.service.UserUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserUpdateView;

public class UserUpdateController {

    UserUpdateService service;
    UserUpdateView view;

    public UserUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateInfoUser() {
        view.getOutput(service.updateInfoUser(view.getData()));
        AppStarter.startApp();
    }
}
