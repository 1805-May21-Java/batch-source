package com.revature;


import java.io.File;
import java.io.IOException;

import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.HeroService;

@SpringBootApplication
public class main{

	public static void main(String[] args)  {
		
		SpringApplication.run(main.class, args);


	}

}
