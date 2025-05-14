package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import com.mytests.spring.springBootSmokeTest.web.PersonRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(properties = {"server.port = 8088"}, controllers = PersonRestController.class)
public class PersonControllerTestWebMvcTestProperties {

    @Autowired
    private MockMvc mvc;

   /* @MockitoBean
    PersonRepository personRepository;*/

    @MockitoBean
    PersonService personService;
    @Test
    public void getAllTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testRepoExists() {
        assert personService != null;
    }
}
