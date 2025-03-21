package com.mytests.spring.springBootSmokeTest.events;


public class MyEvent1 {
    String text;
    int count;
    public MyEvent1(String text, int count){
        this.text = text;
        this.count = count;
    }
    public String getText() {
        return text;
    }
    public int getCount() {
        return count;
    }
}
