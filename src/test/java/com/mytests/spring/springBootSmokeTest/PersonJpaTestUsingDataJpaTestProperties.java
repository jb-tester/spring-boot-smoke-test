package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest(properties = {"spring.datasource.url=jdbc:h2:file:~/data/test1",
                           "spring.datasource.username=''",
                           "spring.datasource.password=''",
                           "spring.jpa.hibernate.ddl-auto=create-drop"})
@Sql(scripts = {"/sql/create-db.sql", "/sql/insert-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonJpaTestUsingDataJpaTestProperties {


    @Autowired
    private PersonRepository personRepository;

    @Test
    void testRepoExists() {
        assertNotNull(personRepository);

    }

    @Test
    void testCountRows() {
        long count = personRepository.count();
        System.out.println(count);
        assertEquals(8, count);
    }
}
