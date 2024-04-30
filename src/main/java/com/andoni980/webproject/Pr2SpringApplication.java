package com.andoni980.webproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Pr2SpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pr2SpringApplication.class, args);
	}
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("andoni"));
		System.out.println(encoder.encode("iker"));
		
	}

}
