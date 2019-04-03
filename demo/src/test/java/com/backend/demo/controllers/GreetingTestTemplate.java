package com.backend.demo.controllers;

import hello.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingTestTemplate {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName() {
        Greeting greeting = template.getForObject("/greet", Greeting.class);
        assertEquals("Hello, World !", greeting.getName());
    }

    @Test
    public void greetWithName() {
        Greeting greeting = template.getForObject("/greet?name=Jorge", Greeting.class);
        assertEquals("Hello, Jorge !", greeting.getName());
    }
}
