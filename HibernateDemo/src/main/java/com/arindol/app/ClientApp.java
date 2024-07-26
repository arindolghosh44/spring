package com.arindol.app;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.arindol.entity.Account;
import com.arindol.entity.Candidate;
import com.arindol.entity.Customer;
import com.arindol.entity.Employee;
import com.arindol.entity.Product;
import com.arindol.entity.Register;
import com.arindol.entity.Student;
import com.arindol.entity.addhar;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityTransaction tx = null;

		// Reading the persistance.xml file

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppDB");

		// Create table update table

		EntityManager em = emf.createEntityManager();

		tx = em.getTransaction();// Transaction created

		tx.begin();// Login into database

		/*
		 * Product pd1=new Product("p3","phone",90,250000.00);
		 * 
		 * em.persist(pd1);//Data Inserted tx.commit();// permanently save the data
		 * em.clear();
		 */

		/*
		 * Employee e1 = new Employee(); Employee e2 = new Employee();
		 * e1.setEname("binoy"); e1.setEreig("MANAGER"); e1.setSal(25000.00);
		 * e1.setJoindate(new Date()); e1.setWorkinghour(new Date());
		 * 
		 * e2.setEname("suraj"); e2.setEreig("register"); e2.setSal(25000.00);
		 * e2.setJoindate(new Date()); e2.setWorkinghour(new Date());
		 * 
		 * em.persist(e1); em.persist(e2);
		 * 
		 * tx.commit();// permanently save the data em.clear();
		 */

		/*
		 * Candidate c=new Candidate(); Candidate c2=new Candidate(); addhar a=new
		 * addhar(); addhar a1=new addhar(); c.setCndid("c1"); c.setCnum("ANUP");
		 * c2.setCndid("c2"); c2.setCnum("AJOY");
		 * 
		 * 
		 * 
		 * 
		 * a.setAdid("343434"); a.setCity("KOLKATA"); a1.setAdid("565656");
		 * a1.setCity("HYDRABAD");
		 * 
		 * 
		 * 
		 * 
		 * em.persist(c); em.persist(c); em.persist(c2); em.persist(c2); em.persist(a);
		 * em.persist(a); em.persist(a1); em.persist(a1);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * tx.commit(); em.clear();
		 */

		/*
		 * Account ac=new Account(100,15000.00); Account ac1=new Account(101,20000.00);
		 * 
		 * 
		 * Customer cs1=new Customer("c1","binoy",ac); Customer cs2=new
		 * Customer("c2","atul",ac1);
		 * 
		 * em.persist(ac); em.persist(ac1); em.persist(cs1); em.persist(cs2);
		 * 
		 * tx.commit(); em.close();
		 */

		// System.out.println("Insert Opeartion");
		
		/*  Student st=new Student("67","ajoy","IT"); 
		  Student st1=new Student("68","atul","CSE"); 
		  Student st2=new Student("69","subodh","IT");
		  Student st3=new Student("70","subodh","IT"); 
		  Student st4=new Student("71","subodh","IT");
		  Student st5=new Student("72","subodh","IT");*/
		// * 
		// * em.persist(st); em.persist(st1); em.persist(st2); em.persist(st3);
		// * em.persist(st4); em.persist(st5);
	//	 * 
	//	 * /*tx.commit(); em.close();
		 

		/*
		 * System.out.println("Delete the data");
		 * 
		 * Student st6=em.find(Student.class,"3"); Student
		 * st7=em.find(Student.class,"4"); Student st8=em.find(Student.class,"5");
		 * if(st6!=null) { em.remove(st6);
		 * 
		 * }
		 * 
		 * if(st7!=null) { em.remove(st7);
		 * 
		 * }
		 * 
		 * if(st8!=null) { em.remove(st8);
		 * 
		 * }
		 * 
		 * 
		 */

		/*
		 * System.out.println("fetching the data");
		 * 
		 * String jpql1="select s from Student s";
		 * 
		 * Query query1=em.createQuery(jpql1);
		 * 
		 * 
		 * List<Student> slist2=query1.getResultList();
		 * 
		 * 
		 * slist2.stream().forEach(System.out::println);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("Update the data");
		 * 
		 * Student st10=em.find(Student.class,"111");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if(st10!=null) { st10.setSname("binoy power");
		 * 
		 * st10.setSdept("IT");
		 * 
		 * em.merge(st10); }
		 * 
		 */

		/*System.out.println("fetching the data");

		String jpql = "select s from Student s";

		Query query = em.createQuery(jpql);

		List<Student> slist = query.getResultList();

		slist.stream().forEach(System.out::println);
		
		
		
		

		System.out.println("FIND OUT DATA OF CSE DEPT");
		
		String hql = "from Student where sdept=:v_sdept";

		Query query1 = em.createQuery(hql);

		query1.setParameter("v_sdept", "CSE");

		List<Student> slist1 = query1.getResultList();

		slist1.stream().forEach(System.out::println);

		tx.commit();
		em.close();*/
		  
		  
		  
		  Register r=new Register("binoy","1234","arindam","a@gmail.com");
		  Register r1=new Register("suraj","test","DEEP","a23@gmail.com");
		  Register r2=new Register("debashis","1234","binoy","ari@gmail.com");
		  Register r3=new Register("arindol","5678","prateek","a1223@gmail.com");
		  
		  
		//  em.persist(r); em.persist(r1); em.persist(r2); em.persist(r3);
			
		    System.out.println("fetching the data");

		    
			String jpql56 = "select s from Register s";

			Query query47 = em.createQuery(jpql56);

			List<Register> slist34 = query47.getResultList();

			slist34.stream().forEach(System.out::println);
			
			
			
			
			
			
			
			
			
			
			
			
			
		  
			tx.commit();
			em.close();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
