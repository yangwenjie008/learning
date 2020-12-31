package com.aaron.mvc.controller;


import com.aaron.mvc.domain.Gathering;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
//在一个随机端口启动一个mock的server
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testSayHelloWithoutName(){
        ResponseEntity<Gathering> response = template.getForEntity("/rest", Gathering.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,response.getHeaders().getContentType());
        assertFalse(response.getHeaders().getAccessControlAllowCredentials());

        Gathering gathering = response.getBody();
        assert gathering != null;
        assertEquals("Hello, world !",gathering.getMessage());
    }

    @Test
    public void testSayHelloWithName(){
        Gathering gathering = template.getForObject("/rest?name=dash", Gathering.class);
        assertEquals("Hello, dash !",gathering.getMessage());
    }
}