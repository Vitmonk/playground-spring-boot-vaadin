package com.github.vitmonk.spring.vaadin.frontend.clocks;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

import java.time.LocalTime;

/**
 */
@SpringComponent
@ViewScope
public class ViewScopedClock {

    private final LocalTime time = LocalTime.now();

    public String getTime() {
        return this.time.toString();
    }
}
