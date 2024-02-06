package com.mytests.spring.springBootSmokeTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.mytests.spring.springBootSmokeTest.configprops")
public class SpringBootSmokeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSmokeTestApplication.class, args);
    }

}
