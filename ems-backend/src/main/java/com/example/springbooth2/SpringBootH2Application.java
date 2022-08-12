package com.example.springbooth2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.controller","com.example.service"})
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class SpringBootH2Application {
	   public static void main(String[] args) {
		      SpringApplication.run(SpringBootH2Application.class, args);
	   }
}


