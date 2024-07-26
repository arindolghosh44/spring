package com.arindol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//POJO CLASS
@Data
//getter setter and toString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_master")
public class Employee {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int eid;
 @Column(length = 25,nullable = false)
 private String ename;
 @Column(name = "desig",length = 25)
 private String ereig;
 private Double sal;
 @Temporal(TemporalType.DATE)
 private Date joindate;
 @Temporal(TemporalType.TIMESTAMP)
 private Date workinghour;
 
	
}
