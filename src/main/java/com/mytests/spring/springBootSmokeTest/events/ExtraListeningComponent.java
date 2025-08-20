package com.mytests.spring.springBootSmokeTest.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDate;

@Component
public class ExtraListeningComponent {


    private final PersonEventRepository personEventRepository;

    public ExtraListeningComponent(PersonEventRepository personEventRepository) {
        this.personEventRepository = personEventRepository;
    }

    @Async
    @Transactional(
            propagation = Propagation.REQUIRES_NEW
    )
    @TransactionalEventListener
    //@EventListener(PersonCreationEvent.class)
    public void listenPersonAddingEvent(PersonCreationEvent event) {
        String text = event.getText();
        Long id = event.getId();
        System.out.println("New person was added: " + text + "\n Observe events: ");
        personEventRepository.findAll().forEach(System.out::println);
    }


    @EventListener
    public void listenMyEvent2(MyEvent1 event) {
        System.out.println("MyEvent1 listener2: " + event.getText() + "; count: " + event.getCount());
    }
}
