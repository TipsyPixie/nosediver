package com.castledust.nosediver.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@SpringUI
@PropertySource(value = "classpath:constants.properties")
@SpringViewDisplay
public class Root extends UI {

    public static final String SESSION_USERNAME = "username";
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Root.class);
    @Autowired
    Navigator navigator;
    @Value("${nosediver.title}")
    private String title;

    @Override
    protected void init(VaadinRequest request) {

        Page page = getPage();
        page.setTitle(title);

        getNavigator().addViewChangeListener(this::beforeViewChange);
    }

    private boolean beforeViewChange(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        if (viewChangeEvent.getNewView().getClass() == Login.class) {
            return true;
        }

        if (getSession().getAttribute(SESSION_USERNAME) != null) {
            return true;
        } else {
            viewChangeEvent.getNavigator().navigateTo(Login.VIEW_NAME);
            return false;
        }
    }
}
