package com.hamza.shakeel.uniqueEmails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hamza.shakeel.*")
public class UniqueEmailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqueEmailsApplication.class, args);
	}

}
