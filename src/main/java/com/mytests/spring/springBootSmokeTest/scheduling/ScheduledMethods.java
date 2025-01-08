package com.mytests.spring.springBootSmokeTest.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledMethods {


    @Scheduled(fixedRate = 5000)
    public void scheduledMethod() {
        System.out.println("Hello from scheduled method");
    }


}
