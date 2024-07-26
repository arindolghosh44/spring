package com.arindol.SpringCore.bean;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value="emp")
public class Employee {

	
	@Value("${eid}")
	private String eid;
	
	@Value("${ename}")
	private String ename;
	
	@Value("${colgnm}")
	private List<String> colgnm;
	
	
	@Value("${phno}")
	private Set<String> phno;
	
	
	@Value("#{${job}}")
	private Map<String,Double> job;
	
	@Value("#{${info}}")
	private Properties info;
}
