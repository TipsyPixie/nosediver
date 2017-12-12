package com.castledust.nosediver.ui;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
@Title("Nosediver - How good is your social evaluation?")
public class Index extends UI {

    @Override
    protected void init(VaadinRequest request) {

        Button testButton = new Button("Test");
        testButton.addClickListener(event -> Notification.show("test button clicked"));

        setContent(testButton);
    }
}
