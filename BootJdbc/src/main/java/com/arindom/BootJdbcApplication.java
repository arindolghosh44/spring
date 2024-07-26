package com.arindom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
@SpringBootApplication
public class BootJdbcApplication implements CommandLineRunner{

	
	@Autowired
	private JdbcTemplate temp;
	
	private String insert_sql="insert into Account_dtls values('101','tuhin',2.89)";
	private String select_sql="select * from Account_dtls order by accno asc";
	public static void main(String[] args) {
		SpringApplication.run(BootJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	int n=	temp.update(insert_sql);
	
	System.out.println("the number of rows effected"+" "+n);
	
	
	List ac=temp.queryForList(select_sql);
	
	
	ac.stream().forEach(System.out::println);
	
	
		
	}

}
