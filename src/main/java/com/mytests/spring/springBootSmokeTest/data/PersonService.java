package com.mytests.spring.springBootSmokeTest.data;

import com.mytests.spring.springBootSmokeTest.events.MyEvent1;
import com.mytests.spring.springBootSmokeTest.events.PersonCreationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PersonService(PersonRepository personRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.repository = personRepository;
        this.applicationEventPublisher = applicationEventPublisher;
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
        applicationEventPublisher.publishEvent(new PersonCreationEvent(this, person.getFirstname(),person.getLastname(), repository.count()));
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