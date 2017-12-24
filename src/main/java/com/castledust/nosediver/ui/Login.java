package com.castledust.nosediver.ui;

import com.castledust.nosediver.service.security.SecurityUtil;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Login extends VerticalLayout implements View {

    @Autowired
    SecurityUtil securityUtil;

    public Login() {

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login", event -> {
            String usernameInput = usernameField.getValue();
            String passwordInput = passwordField.getValue();

            if(securityUtil.auth(usernameInput, passwordInput)) {
                VaadinSession.getCurrent().setAttribute("username", usernameInput);
            }
            else {
                Notification.show("Wrong username/password");
            }
        });

        FormLayout loginForm = new FormLayout(usernameField, passwordField, loginButton);
        loginForm.setSizeUndefined();
        loginForm.setMargin(true);

        Panel loginPanel = new Panel(loginForm);
        this.addComponent(loginPanel);
        this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
    }
}
