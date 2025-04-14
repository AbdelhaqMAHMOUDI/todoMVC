package com.example.todo_app_mvc_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppMvcSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppMvcSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner testControllerScan(ApplicationContext ctx) {
		return args -> {
			System.out.println("✅ Beans chargés :");
			for (String name : ctx.getBeanDefinitionNames()) {
				if (name.contains("todos") || name.contains("controller")) {
					System.out.println("➡️ " + name);
				}
			}
		};
	}



}
