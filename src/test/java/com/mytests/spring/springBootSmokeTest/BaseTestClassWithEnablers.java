package com.mytests.spring.springBootSmokeTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.event.RecordApplicationEvents;

@RecordApplicationEvents
@AutoConfigureMockMvc
public abstract class BaseTestClassWithEnablers extends BaseTestClass {
}
