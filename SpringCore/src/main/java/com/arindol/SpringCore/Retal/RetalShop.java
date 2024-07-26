package com.arindol.SpringCore.Retal;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.arindol.SpringCore.bean.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "shop")
public class RetalShop {

	@Value("${nid}")
	private String nid;

	@Value("${rnum}")
	private String rnum;

	@Value("${model}")
	private Set<String> model;

	@Value("#{${product}}")
	private Map<String, Double> product;

	@Value("#{${status}}")
	private Map<String, String> status;

	@Value("${consumer}")
	private List<String> consumer;

}
