package com.castledust.nosediver.ui;

import com.castledust.nosediver.repository.UserRepository;
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

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(Root.class);

    @Value("${nosediver.title}")
    private String title;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {

        Page page = getPage();
        page.setTitle(title);
        page.addPopStateListener(event -> {

        });


        Navigator navigator = getNavigator();
        navigator.addView(Login.class.getName(), Login.class);
    }

    private void uriChanged(Page.PopStateEvent popStateEvent) {

        //TODO: uri fragment change event
    }
}
