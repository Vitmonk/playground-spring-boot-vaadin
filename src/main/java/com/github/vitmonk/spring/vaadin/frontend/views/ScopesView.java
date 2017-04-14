package com.github.vitmonk.spring.vaadin.frontend.views;

import com.github.vitmonk.spring.vaadin.frontend.clocks.SessionScopedClock;
import com.github.vitmonk.spring.vaadin.frontend.clocks.SingletonScopedClock;
import com.github.vitmonk.spring.vaadin.frontend.clocks.UIScopedClock;
import com.github.vitmonk.spring.vaadin.frontend.clocks.ViewScopedClock;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 */
@SpringView(name = ScopesView.VIEW_NAME)
public class ScopesView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "ScopesView";

    @Autowired
    private ViewScopedClock viewScopedClock;

    @Autowired
    private UIScopedClock uiScopedClock;

    @Autowired
    private SessionScopedClock sessionScopedClock;

    @Autowired
    private SingletonScopedClock singletonScopedClock;


    private final Label viewScopedClockLabel;
    private final Label uiScopedClockLabel;
    private final Label sessionScopedClockLabel;
    private final Label singletonScopedClockLabel;

    public ScopesView() {
        this.viewScopedClockLabel = new Label();
        this.viewScopedClockLabel.setCaption("View scoped clock (view generation time): ");
        this.uiScopedClockLabel = new Label();
        this.uiScopedClockLabel.setCaption("UI scoped clock (ui gegeration time)");
        this.sessionScopedClockLabel = new Label();
        this.sessionScopedClockLabel.setCaption("Session scoped clock (session start time): ");
        this.singletonScopedClockLabel = new Label();
        this.singletonScopedClockLabel.setCaption("Singleton scoped clock (application start time): ");
    }

    @PostConstruct
    void init() {
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Refresh page and click on tab \"Scopes view\" to see difference between view/UI/session scoped time"));
        this.viewScopedClockLabel.setValue(this.viewScopedClock.getTime());
        this.uiScopedClockLabel.setValue(this.uiScopedClock.getTime());
        this.sessionScopedClockLabel.setValue(this.sessionScopedClock.getTime());
        this.singletonScopedClockLabel.setValue(this.singletonScopedClock.getTime());
        addComponent(this.viewScopedClockLabel);
        addComponent(this.uiScopedClockLabel);
        addComponent(this.sessionScopedClockLabel);
        addComponent(this.singletonScopedClockLabel);
    }
}
