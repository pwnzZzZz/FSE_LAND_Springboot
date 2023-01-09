package com.example.youtubeTutSpringBoot.repositories;

import org.springframework.stereotype.Component;

@Component
public class SayHelloService implements SaySomethingService{
    @Override
    public String saySomething() {
        return "Hello World!";
    }
}
