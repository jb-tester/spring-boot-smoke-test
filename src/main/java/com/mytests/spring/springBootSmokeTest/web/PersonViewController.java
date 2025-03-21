package com.mytests.spring.springBootSmokeTest.web;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.data.Person;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PersonViewController {

    private final MyComponent myComponent;
    private final PersonService personService;

    public PersonViewController(MyComponent myComponent, PersonService personService) {
        this.personService = personService;
        this.myComponent = myComponent;
    }


    @RequestMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("greeting", myComponent.getId());
        List<Person> personList = personService.getAllPersons();
        model.addAttribute("people", personList);
        return "home";
    }

    @RequestMapping("/test")
    public String test(ModelMap model) {
        model.addAttribute("test_attr", "HELLO");
        return "test";
    }
}
