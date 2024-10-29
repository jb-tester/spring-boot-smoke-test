package com.mytests.spring.springBootSmokeTest.configs.beans;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * *
 * <p>Created by irina on 2/24/2024.</p>
 * <p>Project: spring-boot-smoke-test</p>
 * *
 */
public class B1 {

    String id;

    public String getId() {
        return this.id;
    }

    public B1(String id) {
        this.id = id;
    }

    
}