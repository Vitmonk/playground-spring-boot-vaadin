package com.github.vitmonk.spring.vaadin.frontend.clocks;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import java.time.LocalTime;

/**
 */
@SpringComponent
@UIScope
public class UIScopedClock {

    private final LocalTime time = LocalTime.now();

    public String getTime() {
        return this.time.toString();
    }
}
