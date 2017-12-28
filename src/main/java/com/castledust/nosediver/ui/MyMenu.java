package com.castledust.nosediver.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringView(name = MyMenu.VIEW_NAME)
@UIScope
public class MyMenu extends VerticalLayout implements View {

    static final String VIEW_NAME = "MyMenu";
    private static final Logger logger = LoggerFactory.getLogger(MyMenu.class);

    public MyMenu() {

        TextField textField = new TextField(MyMenu.VIEW_NAME);
    }
}
