package com.aaron.springcore.core;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Cat implements Animal,InitializingBean{
    @Override
    public void eat() {
        System.out.println("cat eat fish!!!");
    }

    @PostConstruct
    public void any(){
        System.out.println("cat @PostConstruct method is called");
    }

    public void init(){
        System.out.println("cat init method is called");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat InitializingBean interface method is called");
    }
}
