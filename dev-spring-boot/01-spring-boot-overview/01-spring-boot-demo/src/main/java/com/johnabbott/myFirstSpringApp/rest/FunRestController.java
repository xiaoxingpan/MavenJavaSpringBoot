package com.johnabbott.myFirstSpringApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // This is a restful controller that expose an endpoint which will return "Hello World!"

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring Rest - John Abbott";
    }
}
