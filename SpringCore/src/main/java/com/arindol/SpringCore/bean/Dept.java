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
@Component(value = "fg")
public class Dept {
	
	@Value("D1")
	private String deptid;
	
	@Value("ECE")
	private String dname;
	
	@Autowired
	private Student s;
	
	

}
