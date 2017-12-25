package com.castledust.nosediver.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@SpringUI
@PropertySource(value = "classpath:constants.properties")
public class Root extends UI {

    public static final String SESSION_USERNAME = "username";
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Root.class);
    @Value("${nosediver.title}")
    private String title;

    @Autowired
    Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {

        Page page = getPage();
        page.setTitle(title);
        page.addPopStateListener(this::onUriChange);

        navigator.setErrorView(Login.class);
        navigator.addView(Login.VIEW_NAME, Login.class);
    }

    private void onUriChange(Page.PopStateEvent popStateEvent) {

        if (getSession().getAttribute(SESSION_USERNAME) != null) {
            getNavigator().navigateTo(popStateEvent.getPage().getUriFragment());
        } else {
            getNavigator().navigateTo(Login.VIEW_NAME);
        }
    }
}
