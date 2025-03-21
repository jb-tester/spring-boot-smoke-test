package com.mytests.spring.springBootSmokeTest.events;


import org.springframework.context.ApplicationEvent;


public class PersonCreationEvent extends ApplicationEvent {
    private final String firstname;
    private final String lastname;
    private final Long id;

    public PersonCreationEvent(Object source, String firstname, String lastname, Long id) {
        super(source);
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
    public String getText(){
        return "New person " + this.firstname + " " + this.lastname + " was added";
    }
    public Long getId() {
        return id;
    }
}
