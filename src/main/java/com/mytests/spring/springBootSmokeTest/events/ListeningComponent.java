package com.mytests.spring.springBootSmokeTest.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListeningComponent {
    @MyEventListener(eventClasses = MyEvent1.class, listenIf = "(#event1.text=='myEvent1 occurred')and(#event1.count > 5)")
    public void listenMyEvent1IfConditionCustom(MyEvent1 event1){
        System.out.println("------" + event1.getText() + " " + event1.getCount() + "------");

    }

  /*  @EventListener(classes = MyEvent1.class, condition = "(#event1.text=='myEvent1 occurred')and(#event1.count > 5)")
    public void listenMyEvent1IfCondition(MyEvent1 event1){
        System.out.println("+++event occurred!!!!");
    }*/
}
