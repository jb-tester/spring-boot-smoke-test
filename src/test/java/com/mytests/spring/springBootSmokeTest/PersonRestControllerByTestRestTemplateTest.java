package com.mytests.spring.springBootSmokeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonRestControllerByTestRestTemplateTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getByAgeTest() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/getNamesByAge/25", String.class);
        assertThat(response.getBody()).isEqualTo("Ivan Ivanov, Petr Petrov, ");
    }


    @Test
    public void testPostPerson() throws Exception {
        String personJson = """
                {
                  "firstname": "John",
                  "lastname": "Doe",
                  "age": 10
                }""";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(personJson, headers);
        ResponseEntity<String> response = template.postForEntity("/addPersonRest", request, String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("New person Person{id=9, firstname='John', lastname='Doe', age=10} was added");
    }
}
