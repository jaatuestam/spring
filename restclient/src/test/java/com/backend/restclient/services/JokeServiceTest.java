package com.backend.restclient.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTest {

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Autowired
    private JokeService jokeService;

    @Test
    public void getJoke() {
        String joke = jokeService.getJoke("Lindsay", "Ventimiglia");
        logger.info(joke);
        assertTrue(joke.contains("Lindsay") || joke.contains("Ventimiglia"));
    }


}