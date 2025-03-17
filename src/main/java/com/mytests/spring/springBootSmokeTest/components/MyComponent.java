package com.mytests.spring.springBootSmokeTest.components;

import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import com.mytests.spring.springBootSmokeTest.web.PersonRestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyComponent {

    private final B2 mybean2;
    @Value("${my.conf.props.prop0}")
    String id;

    public MyComponent(B2 mybean2) {
        this.mybean2 = mybean2;
    }

    public String getId() {
        return id;
    }

    public String getMybean2() {
        if (mybean2 == null || mybean2.getId() == null) {
            return "oops";
        } else {
        return mybean2.getId();}
    }
}
