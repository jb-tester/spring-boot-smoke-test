package com.mytests.spring.springBootSmokeTest.events;

import com.mytests.spring.springBootSmokeTest.configprops.NewConfigProps;
import com.mytests.spring.springBootSmokeTest.data.Person;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListeningComponent {

    private final NewConfigProps newConfigProps;

    public ListeningComponent(NewConfigProps newConfigProps) {
        this.newConfigProps = newConfigProps;
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

    @EventListener(PersonCreationEvent.class)
    public void listenPersonAddingEvent(PersonCreationEvent event) {
        System.out.println("New person event: " + event.getText());
    }
}
