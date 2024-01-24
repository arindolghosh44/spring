package com.becoder.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String empName;
	
	
	
	//foreign key
	@OneToOne(mappedBy = "emp",cascade = CascadeType.ALL)
	private Mobile mobile;
	
	@OneToMany(mappedBy = "emp",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List <Address> address;
	
	
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Emp(String empName, Mobile mobile) {
		super();
		this.empName = empName;
		this.mobile = mobile;
	}
	public Emp(int id, String empName, Mobile mobile) {
		super();
		this.id = id;
		this.empName = empName;
		this.mobile = mobile;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", empName=" + empName + ", mobile=" + mobile + "]";
	}
	public Emp(int id, String empName) {
		super();
		this.id = id;
		this.empName = empName;
	}
	public Emp(String empName) {
		super();
		this.empName = empName;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
