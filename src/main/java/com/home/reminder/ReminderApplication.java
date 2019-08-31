package com.home.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@SpringBootApplication
@EntityScan(basePackages = {"com.home.reminder.entities"})
@EnableJpaRepositories("com.home.reminder.repositories")
public class ReminderApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(ReminderApplication.class, args);
		
		
		
	}

}
