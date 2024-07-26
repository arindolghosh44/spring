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
@Component(value="s")
public class Student {
	
	@Value("1")
	private int roll;
	
	@Value("SUMAN")
	private String sname;
	
	
	@Autowired
	private Studentinfo si;
	
	
	

}
