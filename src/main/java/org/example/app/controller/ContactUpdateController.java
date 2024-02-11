package org.example.app.controller;

import org.example.app.service.ContactUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.ContactUpdateView;

public class ContactUpdateController {

    ContactUpdateService service;
    ContactUpdateView view;

    public ContactUpdateController(ContactUpdateService service, ContactUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateContact() {
        view.getOutput(service.updateContact(view.getData()));
        AppStarter.startApp();
    }
}
