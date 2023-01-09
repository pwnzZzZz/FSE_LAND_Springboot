package com.example.youtubeTutSpringBoot.controller;

import com.example.youtubeTutSpringBoot.repositories.SaySomethingService;
import com.example.youtubeTutSpringBoot.services.YoutubeTutSpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaySomethingController {

    @Autowired
    @Qualifier
    SaySomethingService saySomethingService;

    @GetMapping("/")
    public String home() {
        return saySomethingService.saySomething();
    }
}

