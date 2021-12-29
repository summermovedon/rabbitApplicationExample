package com.gismatullin.rabbitapp;

import com.gismatullin.rabbitapp.config.RabbitConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.gismatullin.rabbitapp")
@Import(RabbitConfiguration.class)
public class RabbitappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitappApplication.class, args);
	}

}
