package com.example.youtubeTutSpringBoot.repositories;

import org.springframework.stereotype.Component;

public class SaySomethingConfigurableService implements SaySomethingService{
    private String whatToSay = "";

    @Override
    public String saySomething() {
        return null;
    }

    public String getWhatToSay() {
        return whatToSay;
    }

    public void setWhatToSay(String whatToSay) {
        this.whatToSay = whatToSay;
    }
}
