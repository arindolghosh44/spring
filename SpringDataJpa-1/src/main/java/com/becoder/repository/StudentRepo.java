package com.becoder.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.becoder.entities.*;

public interface StudentRepo  extends JpaRepository<Student, Integer>{

	//custom query
	
	@Query("select u  from Student u where u.name=?1 and u.address=?2")
	Student getStudentByNameAndAddress(String name,String address);
	
	
	
	@Query("select u  from Student u where u.name like :nm")
	List<Student> searchname(@Param(value = "nm") String nm);
	
	@Query("select u  from Student u where u.address like :ad")
	List<Student> searchaddress(@Param(value = "ad") String ad);
	
	
	@Query("select u  from Student u where u.name=:nm  or u.address =:ad")
	List<Student> getBynameOrAddress(@Param(value = "nm") String nm,@Param(value = "ad") String ad);
	
	
	
	
	
	
	
	//custom method we can generated using this jpaRepository
	Student findByName(String name);
	Student findByAddress(String address);
	Student findByNameAndAddress(String name,String address);
	List<Student> findByNameOrId(String name,int id);
	List<Student> findByNameOrAddress(String name,String address);
	
		List<Student> findByNameIsNull();
	List<Student> findByAddressIsNull();
	List<Student> findByNameIsNotNull();
	
	
	List<Student> findByNameLike(String name);
	
	
	List<Student> findByNameStartingWith(String n);
	
	
	List<Student> findByNameContaining(String ch);
	
	List<Student> findByOrderByNameDesc();
	boolean existsByName(String name);
	
	
	
	
}
