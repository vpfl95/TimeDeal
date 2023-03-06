package com.dh.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
public class TimeDealApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TimeDealApplication.class);	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TimeDealApplication.class, args);
	}

}
