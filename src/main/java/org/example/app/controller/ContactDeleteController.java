package org.example.app.controller;

import org.example.app.service.ContactDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.view.ContactDeleteView;

public class ContactDeleteController {

    ContactDeleteService service;
    ContactDeleteView view;

    public ContactDeleteController(ContactDeleteService service, ContactDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteContact() {
        view.getOutput(service.deleteContact(view.getData()));
        AppStarter.startApp();
    }
}
