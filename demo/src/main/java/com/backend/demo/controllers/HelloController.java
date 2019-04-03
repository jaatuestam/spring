package com.backend.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World") String ame , Model model){
        model.addAttribute("user",ame);
        return "hello" ;
    }
}
