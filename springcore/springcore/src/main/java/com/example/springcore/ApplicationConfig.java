package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.example.springcore.beans.Circle;
import com.example.springcore.beans.Shape;
import com.example.springcore.beans.Triangle;

@Configuration
public class ApplicationConfig {

	@Autowired
	Environment environment;
	
	//@Profile("dev")
	@Bean
	public Shape circle() {
		System.out.println(environment.getProperty("shape"));
		return new Circle();
	}
	
	//@Profile("test")
	@Bean
	public Shape triangle() {
		System.out.println(environment.getProperty("shape"));
		return new Triangle();
	}
	
	
}
