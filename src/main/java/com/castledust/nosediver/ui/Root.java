package com.castledust.nosediver.ui;

import com.castledust.nosediver.repository.UserRepository;
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

//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Root.class);

    @Value("${nosediver.title}")
    private String title;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {

        getPage().setTitle(title);
    }
}
