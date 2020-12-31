package com.aaron.mvc.controller;


import com.aaron.mvc.domain.Gathering;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest")
    public Gathering sayHello(@RequestParam(name = "name",defaultValue = "world") final String name){

        return new Gathering(String.format("Hello, %s !", name));
    }


}
