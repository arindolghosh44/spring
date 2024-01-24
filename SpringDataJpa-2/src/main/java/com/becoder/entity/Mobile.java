package com.becoder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mobileName;
	
	@OneToOne
	private Emp emp;
	
	
	
	
	
	
	public Mobile(int id, String mobileName, Emp emp) {
		super();
		this.id = id;
		this.mobileName = mobileName;
		this.emp = emp;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", mobileName=" + mobileName + ", emp=" + emp + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String mobileName) {
		super();
		this.mobileName = mobileName;
	}
	public Mobile(int id, String mobileName) {
		super();
		this.id = id;
		this.mobileName = mobileName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
