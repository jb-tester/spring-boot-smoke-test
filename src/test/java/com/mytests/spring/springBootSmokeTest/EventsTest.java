package com.mytests.spring.springBootSmokeTest;


import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import com.mytests.spring.springBootSmokeTest.events.MyEvent1;
import com.mytests.spring.springBootSmokeTest.events.PersonCreationEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RecordApplicationEvents
public class EventsTest {
    @Autowired
    private ApplicationEvents applicationEvents;

    @Autowired
    private PersonService userService;

    @Test
    void testThatSomeEventsArePublished() {
        assertNotEquals(0,applicationEvents.stream().count());
        applicationEvents.stream().forEach(System.out::println);
    }

    @Test
    void userCreationShouldPublishEvent() {
        this.userService.savePerson(new Person("Donald", "Duck", 30));

        assertEquals(1, applicationEvents
                .stream(PersonCreationEvent.class)
                .filter(event -> event.getText().equals("New person Donald Duck was added"))
                .count());

    }
}
