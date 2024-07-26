package com.arindom.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "dbms.app")
public class DbConn {

	private String driver;
	
	private String url;
	
	private String uname;
	
	
	private String pass;
	
	
	
	
	
}
