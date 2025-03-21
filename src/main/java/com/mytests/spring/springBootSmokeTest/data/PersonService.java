package com.mytests.spring.springBootSmokeTest.data;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public String getAllByLastname(String name) {
        StringBuilder rez = new StringBuilder();
        List<Person> people = repository.customByNameQuery(name);
        people.iterator().forEachRemaining(rez::append);
        return String.valueOf(rez);
    }

    @Transactional
    public String savePerson(Person person) {
        repository.save(person);
        return "New person " + person + " was added";
    }
    public String getNamesOfPeopleOfSpecifiedAge(int age) {
        StringBuilder res = new StringBuilder();
        for (Person person : repository.findByAgeGreaterThan(age)) {
            res.append(person.getFirstname()).append(" ").append(person.getLastname()).append(", ");
        }

        return String.valueOf(res);
    }
}