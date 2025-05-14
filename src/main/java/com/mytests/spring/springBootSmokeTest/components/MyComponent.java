package com.mytests.spring.springBootSmokeTest.components;

import com.mytests.spring.springBootSmokeTest.configs.beans.B1;
import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import com.mytests.spring.springBootSmokeTest.web.PersonRestController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyComponent {

    private final B2 mybean2;
    private final B1 mybean1;
    @Value("${my.conf.props.prop0}")
    String id;

    public MyComponent(B2 mybean2, // the error should not appear since there are the mutually exclusive conditions
                       @Qualifier("mybean11") // should be intention to add qualifier if it is commented-out
                       B1 mybean1)
    {

        this.mybean2 = mybean2;
        this.mybean1 = mybean1;
    }

    public String getId() {
        return id + ":  " + mybean2.getId() + "; qualifiers test: " + mybean1.getId();
    }

    public String getMybean2() {
        if (mybean2 == null || mybean2.getId() == null) {
            return "oops";
        } else {
        return mybean2.getId();}
    }
}
