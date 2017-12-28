package com.castledust.nosediver.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@SpringUI
@PropertySource(value = "classpath:constants.properties")
@SpringViewDisplay
public class Root extends UI {

    public static final String SESSION_USERNAME = "username";
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Root.class);
    @Autowired
    private SpringNavigator springNavigator;
    @Value("${nosediver.title}")
    private String title;

    @Override
    protected void init(VaadinRequest request) {

        Page page = getPage();
        page.setTitle(title);

        ArrayList<Button> buttons = new ArrayList<>();
        Button myMenuButton = new Button(MyMenu.VIEW_NAME, event -> {
            springNavigator.navigateTo(MyMenu.VIEW_NAME);
        });
        buttons.add(myMenuButton);

        VerticalLayout buttonBar = new VerticalLayout();
        for(Button button : buttons) {
            buttonBar.addComponent(button);
        }
        buttonBar.setHeight(100, Unit.PERCENTAGE);
        buttonBar.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        VerticalLayout innerContainer = new VerticalLayout();
        innerContainer.setHeight(100, Unit.PERCENTAGE);
        innerContainer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        HorizontalLayout container = new HorizontalLayout(buttonBar, innerContainer);
        setContent(container);

        springNavigator.init(this, innerContainer);
        springNavigator.addViewChangeListener(this::beforeViewChange);
    }

    private boolean beforeViewChange(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

//        if (viewChangeEvent.getNewView().getClass() == Login.class) {
//            return true;
//        }
//
//        if (getSession().getAttribute(SESSION_USERNAME) != null) {
//            return true;
//        } else {
//            viewChangeEvent.getNavigator().navigateTo(Login.VIEW_NAME);
//            return false;
//        }

        return true;
    }
}
