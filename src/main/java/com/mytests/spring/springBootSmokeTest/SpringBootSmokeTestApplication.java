package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.events.MyEvent1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.mytests.spring.springBootSmokeTest.configprops")
@EnableAsync
public class SpringBootSmokeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSmokeTestApplication.class, args);
    }
        @Bean
            public CommandLineRunner commandLineRunner(ApplicationContext ctx, ApplicationEventPublisher publisher) {
                return args -> {
                    System.out.println("--------------------------------------");
                    publisher.publishEvent(new MyEvent1("myEvent1 occurred", 11));
                    System.out.println("--------------------------------------");
                };
            }
}
