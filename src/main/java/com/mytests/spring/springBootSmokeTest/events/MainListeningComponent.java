package com.mytests.spring.springBootSmokeTest.events;

import com.mytests.spring.springBootSmokeTest.configprops.NewConfigProps;
import com.mytests.spring.springBootSmokeTest.data.PersonService;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDate;

@Component
public class MainListeningComponent {

    private final NewConfigProps newConfigProps;
    private final PersonService personService;

    public MainListeningComponent(NewConfigProps newConfigProps, PersonService personService) {
        this.newConfigProps = newConfigProps;
        this.personService = personService;
    }


    @MyEventListener(eventClasses = MyEvent1.class, listenIf = "(#event1.text=='myEvent1 occurred')and(#event1.count > 5)")
    public void listenMyEvent1IfConditionCustom(MyEvent1 event1){
        System.out.println("------" + event1.getText() + " " + event1.getCount() + "------");

    }

    @EventListener
    public void on(ApplicationStartedEvent event) {
        System.out.println(newConfigProps.getPojo().getStr());
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

  /*  @EventListener(classes = MyEvent1.class, condition = "(#event1.text=='myEvent1 occurred')and(#event1.count > 5)")
    public void listenMyEvent1IfCondition(MyEvent1 event1){
        System.out.println("+++event occurred!!!!");
    }*/

    @Async
    @Transactional(
            propagation = Propagation.REQUIRES_NEW
    )
    @TransactionalEventListener
    //@EventListener(PersonCreationEvent.class)
    public void listenPersonAddingEventAndPrintTheResultedDB(PersonCreationEvent event) {
        System.out.println("Main listener: personCreationEvent occurred: person "  + event.getText() + " was added");
        System.out.println("Now all persons: ");
        personService.getAllPersons().forEach(System.out::println);
        System.out.println("++++++++++++++++");
    }
}
