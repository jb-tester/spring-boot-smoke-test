package com.mytests.spring.springBootSmokeTest.events;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventListener
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEventListener {
    @AliasFor(annotation = EventListener.class, attribute = "classes")
    Class<?>[] eventClasses() default {};
    @AliasFor(annotation = EventListener.class, attribute = "condition")
    String listenIf() default "";
}