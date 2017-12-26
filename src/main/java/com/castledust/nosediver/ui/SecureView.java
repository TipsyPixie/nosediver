package com.castledust.nosediver.ui;

import com.vaadin.navigator.View;

public interface SecureView extends View {

    boolean needAuth();
}
