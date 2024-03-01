package com.amit.gl.ZEMPMGMT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amit.gl.empmgmt.entity.Employee;
import com.amit.gl.empmgmt.service.EmployeeService;

@Controller
@RequestMapping("/EMS")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public String getAllEmployee(Model model) {
		List<Employee> emp = employeeService.findAll();
		model.addAttribute("Employee", emp);
		return "employee-list";
	}
}
