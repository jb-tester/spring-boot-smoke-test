package com.mytests.spring.springBootSmokeTest.web;

import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/customByLastname/{name}")
    public String personByLastName(@PathVariable String name) {
        return personService.getAllByLastname(name);
    }

    @PostMapping("/addPersonRest")
    public String addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/getNamesByAge/{age:[0-9]+}")
    public String getNamesByAge(@PathVariable("age") int age) {
        return personService.getNamesOfPeopleOfSpecifiedAge(age);
    }
}