package com.arindol.SpringCore.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arindol.SpringCore.Retal.RetalShop;
import com.arindol.SpringCore.bean.Catagory;
import com.arindol.SpringCore.bean.Customer;
import com.arindol.SpringCore.bean.Dept;
import com.arindol.SpringCore.bean.Employee;
import com.arindol.SpringCore.bean.Studentinfo;
import com.arindol.SpringCore.config.SpringConfig;

public class ClientApp {

	public static void main(String [] args)
	{
		
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		
		//Customer c=(Customer)ac.getBean("cs");
		/*Employee e=(Employee)ac.getBean("emp");
		System.out.println(e);*/
		
		/*RetalShop r=(RetalShop)ac.getBean("shop");
		System.out.println(r);
		*/
		
		
		/*Catagory cg=(Catagory)ac.getBean("bs");
		System.out.println(cg);*/
		
		
		
		Dept cg=(Dept)ac.getBean("fg");
		System.out.println(cg);
		
		Studentinfo g=(Studentinfo)ac.getBean("ty");
		
		System.out.println(g);
		
	}
	
	
	
}
