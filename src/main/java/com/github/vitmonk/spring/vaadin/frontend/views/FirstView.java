package com.github.vitmonk.spring.vaadin.frontend.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 */
@SpringView(name = FirstView.VIEW_NAME)
public class FirstView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "FirstView";

    @PostConstruct
    void init() {
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("First view"));
    }
}
