package com.mytests.spring.springBootSmokeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
}
