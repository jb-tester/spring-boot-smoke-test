package com.mytests.spring.springBootSmokeTest.components;

import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyComponent {

    @Value("${my.conf.props.prop0}")
    String id;

    public String getId() {
        return id;
    }

}
