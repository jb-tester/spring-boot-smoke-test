package com.mytests.spring.springBootSmokeTest.configs.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * *
 * <p>Created by irina on 2/24/2024.</p>
 * <p>Project: spring-boot-smoke-test</p>
 * *
 */
public class B2 {

    String id;

   @Qualifier("mybean12")
    @Autowired
    private B1 bean1; // should be intention to add qualifier if it is commented-out

    public String getId() {
        return this.id + bean1.getId();
    }

    public B2(String id) {
        this.id = id;
    }
}    