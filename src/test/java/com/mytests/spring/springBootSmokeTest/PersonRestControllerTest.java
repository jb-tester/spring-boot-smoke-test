package com.mytests.spring.springBootSmokeTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytests.spring.springBootSmokeTest.data.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonRestControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void getByNameTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customByLastname/Petrov").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Person{id=1, firstname='Ivan', lastname='Petrov', age=25}Person{id=3, firstname='Petr', lastname='Petrov', age=30}")));
	}

	@Test
	void addPersonTest() throws Exception {
		Person someClass = new Person("Ivan", "Testov", 25);
		String json = mapper.writeValueAsString(someClass);
		mvc.perform(post("/addPersonRest")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}