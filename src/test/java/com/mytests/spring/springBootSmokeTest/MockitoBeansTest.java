package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.configs.beans.B1;
import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import com.mytests.spring.springBootSmokeTest.data.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoBeans;

@SpringBootTest
@MockitoBeans(
        {
        @MockitoBean(types = MyComponent.class),
        @MockitoBean(types = B1.class, name = "mybean11")
        }
)
public class MockitoBeansTest {

 @Autowired private MyComponent myComponent;
 @Autowired private B1 mybean11;
 @MockitoBean private B2 b2;

 @MockitoBean
 private PersonRepository repository;

   @Test
   public void myComponentTest() {
       Assertions.assertNotNull(myComponent);
       Assertions.assertNull(myComponent.getId());
   }
    @Test
    public void bean1Test() {
        Assertions.assertNotNull(mybean11);
        Assertions.assertNull(mybean11.getId());
    }
    @Test
    public void bean2Test() {
        Assertions.assertNotNull(b2);
        Assertions.assertNull(b2.getId());
    }

}
