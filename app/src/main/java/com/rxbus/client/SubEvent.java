package com.rxbus.client;

/**
 * Created by 64860 on 2017/8/4.
 */

public class SubEvent {

    private String name;
    private String age;

    public SubEvent(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
