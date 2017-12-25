package com.castledust.nosediver.ui;

import com.castledust.nosediver.service.security.SecurityUtil;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@SpringView
@Scope(value = "prototype")
public class Login extends VerticalLayout implements View {

    public static final String VIEW_NAME = "Login";
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    @Autowired
    private SecurityUtil securityUtil;

    public Login() {

        logger.info("!!!! new Login");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login", event -> {
            String usernameInput = usernameField.getValue();
            String passwordInput = passwordField.getValue();

            if (securityUtil.auth(usernameInput, passwordInput)) {
                VaadinSession.getCurrent().setAttribute(Root.SESSION_USERNAME, usernameInput);
            } else {
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
