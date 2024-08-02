package com.example.med_cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class MedCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedCardsApplication.class, args);
	}
}
