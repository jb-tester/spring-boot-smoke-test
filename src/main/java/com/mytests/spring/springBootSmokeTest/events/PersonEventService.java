package com.mytests.spring.springBootSmokeTest.events;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
class PersonEventService {

    private final PersonEventRepository personEventRepository;

    PersonEventService(PersonEventRepository personEventRepository) {
        this.personEventRepository = personEventRepository;
    }
    public void saveEvent(PersonEvent personEvent){
        personEventRepository.save(personEvent);
    }
    public List<String> getAllEvents(){
        List<String> rez = new ArrayList<>();
       personEventRepository.findAll().forEach(personEvent -> rez.add(personEvent.toString()));
       return rez;}
}
