package com.example.youtubeTutSpringBoot.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Wenn des Programm startet, erzeugt diese Klasse Beans
//und legt diese in den ApplicationContext
@Configuration
public class SaySomethingConfiguration {


    @Bean
    @Primary
    public SaySomethingConfigurableService saySomethingConfigurableService(){
        SaySomethingConfigurableService saySomethingConfigurableService = new SaySomethingConfigurableService();
        saySomethingConfigurableService.setWhatToSay("Goodbye");
        return saySomethingConfigurableService;
    }
}
