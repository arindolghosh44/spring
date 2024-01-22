package com.becoder.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.becoder.entity.Employee;
import com.becoder.service.EmpService;



@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	
	
	@GetMapping("/")
	public String index(Model m) {
		
	List<Employee>list	=service.getAllEmp();
		
		m.addAttribute("list1",list);
		
		
		
		return "index";
	}

	@GetMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}

	@PostMapping("/register")
	public String EmpRegister(@ModelAttribute Employee emp) {
		
		
		service.addEmp(emp);
		
		return "redirect:/";
	}

	

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e=service.getEmpById(id);
		
		m.addAttribute("emp",e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e)
	{
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		service.deleteEmp(id);
		return "redirect:/";
	}
	
	
	
	
	
	
}
