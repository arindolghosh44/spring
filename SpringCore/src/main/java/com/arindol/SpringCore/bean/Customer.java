package com.arindol.SpringCore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "cs")//creating the object of spring bean class in container
public class Customer {

	@Value("C1")
	
	private String cid;//three Premitive type dependencies
	
	@Value("Ashok")
	private String cname;
	
	@Value("983")
	private String cphno;
	
	
	
	
}
