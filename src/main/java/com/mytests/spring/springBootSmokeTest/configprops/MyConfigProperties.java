package com.mytests.spring.springBootSmokeTest.configprops;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@ConfigurationProperties("my.conf.props")
public class MyConfigProperties {
    public MyConfigProperties(String prop0, Map<String, InnerPojo> pojoMap) {
        this.prop0 = prop0;
        this.pojoMap = pojoMap;
    }

    String prop0 = "prop0_default";

    Map<String,InnerPojo> pojoMap;

    public static class InnerPojo {
        String str;
        List<String> strList;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public List<String> getStrList() {
            return strList;
        }

        public void setStrList(List<String> strList) {
            this.strList = strList;
        }
    }
}
