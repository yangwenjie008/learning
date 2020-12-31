package com.aaron.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;


class HelloControllerUnitTest {

    @Test
    public void testSayHello(){
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();

        String hello = helloController.sayHello("world",model);
        assertEquals("hello",hello);
        assertEquals("world",model.asMap().get("user"));
        assertEquals("world",model.getAttribute("user"));
    }

}