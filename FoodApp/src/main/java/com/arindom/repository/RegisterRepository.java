package com.arindom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arindom.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,String>{

	@Query("from Register where uname=:uname and pass=:pass")
	public Register checkLogin(String uname,String pass);
}
