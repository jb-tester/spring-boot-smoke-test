package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:file:~/data/test2", "spring.datasource.username=''", "spring.datasource.password=''","spring.jpa.hibernate.ddl-auto=create-drop"})
@Sql(scripts = {"/sql/create-db.sql", "/sql/insert-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class PersonJpaTestUsingTestPropertySources {


    @Autowired
    private PersonRepository personRepository;

    @Test
    void testRepo() {
        assertNotNull(personRepository);

    }

    @Test
    void testCount() {
        long count = personRepository.count();
        System.out.println(count);
        assertEquals(8, count);
    }
}
