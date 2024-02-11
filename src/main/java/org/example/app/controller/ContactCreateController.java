package org.example.app.controller;

import org.example.app.service.ContactCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.ContactCreateView;

public class ContactCreateController {

    ContactCreateView view;
    ContactCreateService service;

    public ContactCreateController(ContactCreateService service, ContactCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createContact() {
        view.getOutput(service.createContact(view.getData()));
        AppStarter.startApp();
    }
}
