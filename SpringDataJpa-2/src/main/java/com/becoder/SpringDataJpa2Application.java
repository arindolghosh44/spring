package com.becoder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.becoder.entity.Address;
import com.becoder.entity.Catagory;
import com.becoder.entity.Emp;
import com.becoder.entity.Mobile;
import com.becoder.entity.Product;
import com.becoder.repository.*;

@SpringBootApplication
public class SpringDataJpa2Application implements CommandLineRunner {

	@Autowired
	private EmpRepo empRep;
	@Autowired
	private MobileRepo mobrepo;
	@Autowired
	private AddressRepo addRepo;
	@Autowired
	private CatagoryRepo cateRepo;
	@Autowired
	private ProductRepo proRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa2Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Emp emp = new Emp(); emp.setEmpName("becodee");
		 * 
		 * Mobile mb = new Mobile(); mb.setMobileName("677");
		 * 
		 * // emp.setMobile(mb);
		 * 
		 * mb.setEmp(emp); empRep.save(emp); mobrepo.save(mb);
		 * 
		 * // bidirectTional
		 * 
		 * Emp emp1 = empRep.findById(1).get();
		 * 
		 * System.out.println(emp1.getEmpName());
		 * 
		 * System.out.println(emp1.getMobile().getMobileName());
		 * 
		 * Mobile mb1 = mobrepo.findById(1).get();
		 * 
		 * System.out.println(mb1.getMobileName());
		 * 
		 * System.out.println(mb1.getEmp().getEmpName());
		 */

		// one to many and many to one

		/*
		 * Emp emp = new Emp(); emp.setEmpName("becodee");
		 * 
		 * Address ad = new Address();
		 * 
		 * ad.setAddress("kks"); ad.setType("premr"); ad.setEmp(emp);
		 * 
		 * Address ad1 = new Address();
		 * 
		 * ad1.setAddress("uk"); ad1.setType("permanent"); ad1.setEmp(emp);
		 * 
		 * Address ad2 = new Address();
		 * 
		 * ad2.setAddress("usa"); ad2.setType("default"); ad2.setEmp(emp);
		 * 
		 * Address ad3 = new Address();
		 * 
		 * ad3.setAddress("amersts"); ad3.setType("premr"); ad3.setEmp(emp);
		 * 
		 * List<Address> list = Arrays.asList(ad, ad1, ad2, ad3);
		 * 
		 * list.forEach(e -> System.out.println(e));
		 * 
		 * emp.setAddress(list); empRep.save(emp);
		 */

		/*
		 * Emp emp =empRep.findById(17).get();
		 * 
		 * System.out.println(emp.getEmpName()) ;
		 * 
		 * 
		 * emp.getAddress().forEach(e->System.out.println(e));
		 * 
		 */

		/*
		 * Address add= addRepo.findById(3).get();
		 * 
		 * System.out.println(add); System.out.println(add.getType());
		 * System.out.println(add.getAddress());
		 * 
		 * 
		 * 
		 * System.out.println(add.getEmp().getEmpName());
		 */

		
		
		
		
		
		
		
		
		
		//many to many
	/*	Catagory ca1 = new Catagory();

		ca1.setCatagoryName("Electronics");

		Catagory ca2 = new Catagory();

		ca2.setCatagoryName("Mobile");

		Product p1 = new Product();
		p1.setProductName("Tv");

		Product p2 = new Product();
		p2.setProductName("samsung");
		
		
		Product p3 = new Product();
		p3.setProductName("Iphone");

		
		
		ca1.getProducts().add(p1);
		ca1.getProducts().add(p2);
		ca1.getProducts().add(p3);
		
		
		
		ca2.getProducts().add(p2);
		ca2.getProducts().add(p3);
		
		
		p1.getCatagories().add(ca1);
		p2.getCatagories().add(ca1);
		p2.getCatagories().add(ca1);
		
		
		p2.getCatagories().add(ca2);
		p3.getCatagories().add(ca2);
		
		
		
		
		cateRepo.save(ca1);
		
		cateRepo.save(ca2);
		
		
		
		*/
		
		
		
		
		
	/*Catagory ca=cateRepo.findById(2).get();	
	System.out.println(ca.getCatagoryName());
	ca.getProducts().forEach(e->System.out.println(e.getProductName()));
		*/
		
		
		/*Product p=proRepo.findById(1).get();
		System.out.println(p.getProductName());
		p.getCatagories().forEach(e->System.out.println(e.getCatagoryName()));
		*/
		
		
		
		
		
		
		
		
		
		
		

	}

}
