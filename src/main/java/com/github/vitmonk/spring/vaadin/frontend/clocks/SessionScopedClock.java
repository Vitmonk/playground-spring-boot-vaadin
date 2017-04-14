package com.github.vitmonk.spring.vaadin.frontend.clocks;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;

import java.io.Serializable;
import java.time.LocalTime;

/**
 */
@SpringComponent
@VaadinSessionScope
public class SessionScopedClock implements Serializable {

    private final LocalTime time = LocalTime.now();

    public String getTime() {
        return this.time.toString();
    }
}
