package com.github.vitmonk.spring.vaadin.frontend;

import com.github.vitmonk.spring.vaadin.frontend.views.FirstView;
import com.github.vitmonk.spring.vaadin.frontend.views.ScopesView;
import com.github.vitmonk.spring.vaadin.frontend.views.SecondView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Main page.
 */
@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MainPage extends UI implements ViewDisplay {

    private Panel springViewDisplay;

    @Override
    protected void init(final VaadinRequest vaadinRequest) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        setContent(root);

        root.addComponent(new Label("Session ID: " + vaadinRequest.getWrappedSession().getId()));

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        navigationBar.addComponent(createNavigationButton("First view", FirstView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Second view", SecondView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Scopes view", ScopesView.VIEW_NAME));
        root.addComponent(navigationBar);

        this.springViewDisplay = new Panel();
        this.springViewDisplay.setSizeFull();
        root.addComponent(this.springViewDisplay);
        root.setExpandRatio(this.springViewDisplay, 1.0f);
    }

    @Override
    public void showView(final View view) {
        this.springViewDisplay.setContent((Component) view);
    }

    private Button createNavigationButton(final String caption, final String viewName) {
        final Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}
