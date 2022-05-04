package com.example.discuss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.*")
@EntityScan("com.example.entities")
@EnableJpaRepositories("com.example.repository")
public class DiscussApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscussApplication.class, args);
	}

}
