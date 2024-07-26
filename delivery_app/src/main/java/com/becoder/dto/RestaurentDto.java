package com.becoder.dto;

import lombok.Data;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class RestaurentDto {
	
	private String title;
	
	@Column(length =1000)
	private List<String> images;
	 
	
	private String description;
	
	private Long id;

}
