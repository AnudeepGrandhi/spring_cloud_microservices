package com.practice.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.annotations.modal.Employee;

@SpringBootApplication
public class AnnotationsApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee.getAddress());
		
	}
	
	

}
