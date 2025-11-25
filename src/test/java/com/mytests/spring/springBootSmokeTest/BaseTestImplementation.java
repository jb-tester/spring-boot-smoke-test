package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import com.mytests.spring.springBootSmokeTest.events.PersonCreationEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BaseTestImplementation extends BaseTestClassWithEnablers {

    @Autowired
    private ApplicationEvents applicationEvents;

    // false error that occurs since the enabler is in the base class
    @Autowired
    private MockMvc mvc;


    @Autowired
    private PersonService userService;

    @Test
    void userCreationShouldPublishEvent() {
        this.userService.savePerson(new Person("Donald", "Duck", 30));

        assertEquals(1, applicationEvents
                .stream(PersonCreationEvent.class)
                .filter(event -> event.getText().equals("New person Donald Duck was added"))
                .count());

    }

    @Test
    void testControllerGetmethod() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
