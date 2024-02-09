package com.mytests.spring.springBootSmokeTest.web;

import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonRestController {

    private final PersonRepository repository;

    public PersonRestController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Person> getAll() {

        return repository.findAll();
    }

    @GetMapping("/customByLastname/{name}")
    public String personByLastName(@PathVariable String name) {
        StringBuilder rez = new StringBuilder();
        List<Person> people = repository.customByNameQuery(name);
        people.iterator().forEachRemaining(rez::append);
        return String.valueOf(rez);
    }

    @Transactional
    @PostMapping("/addPersonRest")
    public String addPerson(@RequestBody Person person) {
        repository.save(person);
        return "New person " + person + " was added";
    }

}    