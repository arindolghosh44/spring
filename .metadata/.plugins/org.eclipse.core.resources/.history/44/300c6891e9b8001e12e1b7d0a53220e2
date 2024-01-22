package com.becoder;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.becoder.entities.Student;
import com.becoder.repository.StudentRepo;import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa1Application.class, args);
		StudentRepo stRepo=context.getBean(StudentRepo.class);
		
		
	//	Insertion
			/*	Student st=new Student();
				st.setName("thor");
				st.setAddress("uk");
				stRepo.save(st);
				
				
				
				
				
				Student st1=new Student();
				st1.setName("hela");
				st1.setAddress("usa");
				stRepo.save(st1);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				Student st2=new Student();
				st2.setName("indial");
				st2.setAddress("india");
				stRepo.save(st2);
				
				
				*/
				
				
				
				
				
				
				
				
				
				
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
				
				
				
				
				
				
				
				
				
				
		/*		//////////////////delete
				Student str1=stRepo.findById(1).get();
				System.out.println(str1);
				stRepo.delete(str1);
				
				
				*/
				
				
				
				
			//custom method	of name
			//Student st=stRepo.findByName("becodershhshsshsh");	
			//	System.out.println(st);
				
				
				//custom method	of address
			//	Student st=stRepo.findByAddress("djjdsjsjssss");	
				//	System.out.println(st);
				
		//custom method for both name and address
		//Student st=stRepo.findByNameAndAddress("becodershhshsshsh", "djjdsjsjssss");
	//System.out.println(st);
					
		
		
		
		//custom method for id or name
		//here we get "id" name data and "name" data also
/*	List<Student>st=stRepo.findByNameOrAddress("thor","india");
		
	st.forEach(e->System.out.println(e));
		
		*/
		
		
		
		
		
	/*	List<Student>st=stRepo.findByNameIsNotNull();
		
		st.forEach(e->System.out.println(e));
				
		*/		
				
				
/*List<Student>st=stRepo.findByNameLike("becodershhshs");
		
		st.forEach(e->System.out.println(e));
		*/
/*		
List<Student>st=stRepo.findByNameStartingWith("b");
		
		st.forEach(e->System.out.println(e));
	*/
		
/*List<Student>st=stRepo.findByOrderByNameDesc();
		
		st.forEach(e->System.out.println(e));
		
	*/	
		
		
		//Custom query
	//Student skwkwt=	stRepo.getStudentByNameAndAddress("thor","uk");
		//System.out.println(skwkwt);
		
//List<Student>st=stRepo.searchname("thor");
		
	//	st.forEach(e->System.out.println(e));
		
		
/*		
List<Student>st=stRepo.searchaddress("uk");
		
		st.forEach(e->System.out.println(e));
	*/
/*		
List<Student>st=stRepo.getBynameOrAddress("thor","india");
		
		st.forEach(e->System.out.println(e));
		
	*/
		
		
	
		
		
	//pagination	
	
		
		
		
		
		
		
		
		
		Sort sort=Sort.by("name").ascending();
		//Sort sort=Sort.by("id").ascending();
		
		List<Student>listSortStudent=stRepo.findAll(sort);
		System.out.println("-----------sorting student details---------------");
		listSortStudent.forEach(e->System.out.println(e));
		System.out.println("--------------------------");
		org.springframework.data.domain.Pageable pageable=PageRequest.of(0, 5,sort);
		
		
		Page<Student>page=stRepo.findAll(pageable);
		page.get().forEach(e->System.out.println(e));
		System.out.println("Size= "+page.getSize());
		System.out.println("Total elements= "+page.getTotalElements());
		System.out.println("Pages= "+page.getTotalPages());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
