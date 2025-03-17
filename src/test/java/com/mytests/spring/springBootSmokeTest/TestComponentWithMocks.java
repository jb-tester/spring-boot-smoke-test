package com.mytests.spring.springBootSmokeTest;

import com.mytests.spring.springBootSmokeTest.components.MyComponent;
import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestComponentWithMocks {

    @MockitoBean
    private B2 myBean2;

    @Autowired
    private MyComponent myComponent;

    @Test
    void testComponent() {
        String mybean2 = myComponent.getMybean2();
        assertThat(mybean2).isEqualTo("oops");
    }

}
