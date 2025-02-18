package com.ride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication

public class AllnewApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  context=SpringApplication.run(AllnewApplication.class, args);
		
		
		MyApp app=context.getBean(MyApp.class);
		
		System.out.println(app.getAppName());
		
		//app.getDes();
		
		//app.getVersion();
	}

}
