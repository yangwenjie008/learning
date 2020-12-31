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
class GitHubServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GitHubService service;


    @Test
    public void getHtmlUrl(){
        String htmlUrl = service.getHtmlUrl("yangwenjie008");
        logger.info(htmlUrl);
        assertTrue(htmlUrl.contains("yangwenjie008"));
    }
}