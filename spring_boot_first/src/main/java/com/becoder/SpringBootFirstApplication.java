package com.becoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.becoder.config.MyMessage;

@SpringBootApplication
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootFirstApplication.class, args);
		
		MyMessage msg=context.getBean(MyMessage.class);
		
	
		
		System.out.println(msg.getMsg());
		
		
		
		
	}

}
