package com.arindom.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {

	@Value("c1")
	private String cid;
	
	@Value("subham")
	private String cname;
	
	@Value("568484")
	private String cphno;
	
}
