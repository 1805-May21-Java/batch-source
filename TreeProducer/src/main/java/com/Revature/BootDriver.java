package com.Revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class BootDriver extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(BootDriver.class);
//	}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(BootDriver.class, args);
//	}
//
//}

@SpringBootApplication
public class BootDriver {
	public static void main(String args[]) {
		SpringApplication.run(BootDriver.class, args);
	}
}