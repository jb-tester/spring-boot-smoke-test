package com.mytests.spring.springBootSmokeTest.configs;

import com.mytests.spring.springBootSmokeTest.configs.beans.B2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mytests.spring.springBootSmokeTest.configs.beans.B1;


@Configuration
public class MyConfig {

   // multiple beans with the same name but opposite conditions
    @Bean(name = "mybean2")
    @ConditionalOnProperty(name = "my.conf.props.flag", havingValue = "true")
    public B2 mybean21() {
        return new B2("flag is true");
    }
    @Bean(name = "mybean2")
    @ConditionalOnProperty(name = "my.conf.props.flag", havingValue = "false")
    public B2 mybean22() {
        return new B2("flag is false or not set");
    }
    // multiple beans with the same type but different names
    @Bean
    public B1 mybean11() {
        return new B1("first");
    }
    @Bean
    public B1 mybean12() {
        return new B1("second");
    }
}
