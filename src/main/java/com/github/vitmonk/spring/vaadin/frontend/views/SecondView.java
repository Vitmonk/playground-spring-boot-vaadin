package com.github.vitmonk.spring.vaadin.frontend.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 */
@SpringView(name = SecondView.VIEW_NAME)
public class SecondView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "SecondView";

    @PostConstruct
    void init() {
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Second view"));
    }
}
