package com.backend.demo.controllers;

import hello.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GrettingController {

    private AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/greet")
    public Greeting sayHello(@RequestParam(defaultValue = "World")String name){
        return new Greeting(atomicLong.incrementAndGet(), String.format("Hello, %s !", name));
    }
}
