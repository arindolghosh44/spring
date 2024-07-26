package com.arindom;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arindom.entity.Product;
import com.arindom.service.ProductService;

@SpringBootApplication
public class BootDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductService p;
	
	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INSERT DATA AND TABLE CREATED");
		
		Product p1=new Product("p6","TV",4,75000.00);
		p.addData(p1);
		
		
		Product p2=new Product("p7","TV",1,45000.00);
		p.addData(p2);
		
		
	/*	System.out.println("display The Data");
		
		List<Product> list=p.getDATA();
		
		list.stream().forEach(System.out::println);
		
		
	//	p.delete("p5");
		
		
         System.out.println("display The Data");
		
		List<Product> list1=p.getDATA();
		
		list1.stream().forEach(System.out::println);
		*/
		
		/*System.out.println("display The Data");
		
		Product po=p.findbyPid("p1");
		System.out.println(po);
		
		*/
		
		/*
       System.out.println("display The Data");
		
		List<Product> list=p.getDATA();
		
		list.stream().forEach(System.out::println);
		System.out.println("Updated value");
		
		p.update("p2");
		
		  System.out.println("display The Data");
			
			List<Product> list1=p.getDATA();
			
			list1.stream().forEach(System.out::println);
		*/
		
		
		
		
		
		/*List<Product> tuhin = p.findByName("TV");
		
		tuhin.stream().forEach(System.out::println);
		
		*/
		
      /*  List<Product> tuhin = p.findByPrice();
		
		tuhin.stream().forEach(System.out::println);
		*/
		
		/*
		 List<Product> tuhin = p.End();
			
			tuhin.stream().forEach(System.out::println);
			*/
			
			/*List<Product> ronaldo = p.Start();
			
			ronaldo.stream().forEach(System.out::println);*/
		
		
		List<Product> ronaldo = p.Start1();
		
		ronaldo.stream().forEach(System.out::println);
			
		
	}

}
