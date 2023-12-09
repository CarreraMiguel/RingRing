package com.example.RingRing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RingRingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RingRingApplication.class, args);
	}

}
