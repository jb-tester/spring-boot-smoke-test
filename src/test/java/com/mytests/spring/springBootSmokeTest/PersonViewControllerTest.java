package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import com.mytests.spring.springBootSmokeTest.web.PersonViewController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PersonViewController.class)
public class PersonViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MyComponent myComponent;

    @MockitoBean
    private PersonService personService;

    // no url navigation if context-path is set - https://youtrack.jetbrains.com/issue/IDEA-373664/Spring-Web-Testing-with-context-path-set-the-URLs-in-tests-are-not-navigable

    @Test
    public void testHomeEndpoint() throws Exception {
        String componentId = "test-component-id";
        when(myComponent.getId()).thenReturn(componentId);
        
        List<Person> personList = Arrays.asList(
            new Person("Ivan", "Smirnov", 30),
            new Person("Janna", "Kuznetsova", 25)
        );
        when(personService.getAllPersons()).thenReturn(personList);

        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("home"))
               .andExpect(model().attribute("greeting", componentId))
               .andExpect(model().attribute("people", personList));
    }

    @Test
    public void testTestEndpoint() throws Exception {
        mockMvc.perform(get("/test"))
               .andExpect(status().isOk())
               .andExpect(view().name("test"))
               .andExpect(model().attribute("test_attr", "HELLO"));
    }
}
