package com.example.youtubeTutSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Erkennt verschiedene Pfade in der URL und kann auf diese
//mit Responses antworten
@RestController
public class HelloWorldController {

    @GetMapping("/hallo")
    public String helloWorld(){
        return "hello world";
    }

}
