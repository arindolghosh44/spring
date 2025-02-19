package com.ride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan({"com.Test", "com.ride", "tttt", "www", "gggg", "hhhh","qqqq"})

public class Allnew2Application {

	public static void main(String[] args) {
		SpringApplication.run(Allnew2Application.class, args);
	}

}
