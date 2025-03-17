package com.mytests.spring.springBootSmokeTest.configprops;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
import java.util.Set;


@ConfigurationProperties(prefix = "custom.config")
public class NewConfigProps {

    private String[] strList;
    private NewInnerPojo pojo;
    private Map<String, String> map;
    private Map<String, NewInnerPojo> mapStrPojo;
    private Map<String, List<String>> mapList;

    public Map<String, List<String>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<String, List<String>> mapList) {
        this.mapList = mapList;
    }

    public String[] getStrList() {
        return strList;
    }

    public void setStrList(String[] strList) {
        this.strList = strList;
    }

    public NewInnerPojo getPojo() {
        return pojo;
    }

    public void setPojo(NewInnerPojo pojo) {
        this.pojo = pojo;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, NewInnerPojo> getMapStrPojo() {
        return mapStrPojo;
    }

    public void setMapStrPojo(Map<String, NewInnerPojo> mapStrPojo) {
        this.mapStrPojo = mapStrPojo;
    }

    public static class NewInnerPojo {
        String str;
        Set<String> strSet;

        public Set<String> getStrSet() {
            return strSet;
        }

        public void setStrSet(Set<String> strSet) {
            this.strSet = strSet;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
