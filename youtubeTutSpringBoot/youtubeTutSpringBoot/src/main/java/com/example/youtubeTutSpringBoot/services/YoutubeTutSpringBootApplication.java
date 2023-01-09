package com.example.youtubeTutSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class YoutubeTutSpringBootApplication {


	/*
	@Component
	public class SayHelloService implements SaySomethingService{

		@Override
		public String saySomething() {
			return "Hello World";
		}
	}
	*/

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(YoutubeTutSpringBootApplication.class, args);
	}

}
