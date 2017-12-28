package com.castledust.nosediver.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringView(name = Main.VIEW_NAME)
@UIScope
public class Main extends VerticalLayout implements View {

    static final String VIEW_NAME = "";
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public Main() {

        TextField textField = new TextField(Main.VIEW_NAME);
    }
}