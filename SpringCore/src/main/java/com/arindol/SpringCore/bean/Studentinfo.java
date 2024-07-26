package com.arindol.SpringCore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value="ty")
public class Studentinfo {
	
	@Value("KOLKATA")
	private String city;
	
	
	@Value("a@gmail.com")
	private String email;
	
	@Value("16363")
	private String phno;
	
	
	
	
	

}
