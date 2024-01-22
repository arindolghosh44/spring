package com.becoder;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import com.becoder.entities.Student;
import com.becoder.repository.StudentRepo;
@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo stRepo=context.getBean(StudentRepo.class);
		
		
		//Insertion
		Student st=new Student();
		st.setName("becodershhshsshsh");
		st.setAddress("djjdsjsjssss");
	//	stRepo.save(st);
		
		
		
		//findall method
		//List <Student> list=(List<Student>)stRepo.findAll();
		//list.forEach( st1 ->System.out.println(st1));
		
		
		
		
		
		//Updatation
	/*	Student str=stRepo.findById(7).get();
		System.out.println(str);
		str.setName("pavy kumer");
		str.setAddress("fkfkf");
		
		stRepo.save(str);
		System.out.println();
		*/
		
		
		
		
		
		
		
		
		
		
		//////////////////delete
		Student str1=stRepo.findById(1).get();
		System.out.println(str1);
		stRepo.delete(str1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
