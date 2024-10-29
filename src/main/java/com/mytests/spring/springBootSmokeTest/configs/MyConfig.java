package com.mytests.spring.springBootSmokeTest.configs;

import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mytests.spring.springBootSmokeTest.configs.beans.B1;

/**
 * *
 * <p>Created by irina on 2/24/2024.</p>
 * <p>Project: spring-boot-smoke-test</p>
 * *
 */
@Configuration
public class MyConfig {
    @Bean
    public B1 mybean11() {
        return new B1("mybean1_1");
    }

    @Bean
    public B2 mybean2() {
        return new B2("mybean2");
    }

    @Bean
    public B1 mybean12() {
        return new B1("mybean1_2");
    }
}
