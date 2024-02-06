package com.mytests.spring.springBootSmokeTest.web;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PersonViewController {

    private final PersonRepository repository;
    private final MyComponent myComponent;

    public PersonViewController(PersonRepository repository, MyComponent myComponent) {
        this.repository = repository;
        this.myComponent = myComponent;
    }


    @RequestMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("greeting", myComponent.getId());
        List<Person> personList = repository.findAll();
        model.addAttribute("people", personList);
        return "home";
    }
}
