package com.castledust.nosediver.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
public class Index extends UI {

    @Override
    protected void init(VaadinRequest request) {

        getPage().setTitle("Nosediver - How good is your social evaluation?");

        Button testButton = new Button("Test");
        testButton.addClickListener(event -> Notification.show("test button clicked"));

        setContent(testButton);
    }
}
