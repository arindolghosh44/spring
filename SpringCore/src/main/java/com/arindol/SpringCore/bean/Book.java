package com.arindol.SpringCore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component(value ="bk")
public class Book {

	@Value("B1")
	private String bid;
	
	@Value("Core Java")
	private String bname;
	
	@Value("1000.98")
	private Double price;
	
	
	
}
