package com.aaron.restclient.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JokeServiceTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JokeService service;


    @Test
    public void getJoke(){
        String joke = service.getJoke("Craig","Walls");
        logger.info(joke);
        assertTrue(joke.contains("Craig")||joke.contains("Walls"));
    }
}