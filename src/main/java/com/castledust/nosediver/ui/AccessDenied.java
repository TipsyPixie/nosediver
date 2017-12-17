package com.castledust.nosediver.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PropertySource(value = "classpath:constants.properties")
public class AccessDenied extends VerticalLayout implements View{

    @Value("${message.accessdenied}")
    private static String deniedMessage;

    public AccessDenied() {

        setMargin(true);

        Label deniedLabel = new Label(deniedMessage);
    }
}
