package com.mytests.spring.springBootSmokeTest.events;

import com.mytests.spring.springBootSmokeTest.data.PersonService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDate;

@Component("qqq")
public class ExtraListeningComponent {


    private final PersonEventService personEventService;

    public ExtraListeningComponent(PersonEventService personEventService) {
        this.personEventService = personEventService;
    }

    @Async
    @Transactional(
            propagation = Propagation.REQUIRES_NEW
    )
    @TransactionalEventListener
    //@EventListener(PersonCreationEvent.class)
    public void listenPersonAddingEventAndSaveEventToBD(PersonCreationEvent event) {
        String text = event.getText();
        Long id = event.getId();
        System.out.println("Extra listener: personCreationEvent will be saved: " + text + "; id: " + id);
        personEventService.saveEvent(new PersonEvent(text, "person event with id "+id, LocalDate.now()));
        System.out.println("Saved events:");
        personEventService.getAllEvents().forEach(System.out::println);
    }



    @EventListener
    public void listenMyEvent2(MyEvent1 event) {
        System.out.println("MyEvent1 listener2: " + event.getText() + "; count: " + event.getCount());
    }
}
