package com.mytests.spring.springBootSmokeTest.web;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


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
        model.addAttribute("persons", repository.findAll());
        return "home";
    }
}
