package com.arindol.SpringCore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "bs")
public class Catagory {

	@Value("Programming Language")
	private String cname; 
	
	@Autowired//when we take other class objects
	private Book b;
	
	
}
