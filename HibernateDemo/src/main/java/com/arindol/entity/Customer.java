package com.arindol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_details")
public class Customer {
    
	@Id
	@Column(length = 10)
	private String cid;
	@Column(length = 25)
	private String cname;
	@OneToOne
	@JoinColumn(name="acc_no")
	private Account acn;
	
	
	
	
	
}
