package com.amit.gl.ZEMPMGMT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.gl.ZEMPMGMT.entity.Employee;
import com.amit.gl.ZEMPMGMT.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm() {
		log.info("EmployeeController addEmployee()");
//		Employee newEmployee = new Employee();
//		model.addAttribute("Employee", newEmployee);
//		employeeService.saveOrUpdate(newEmployee);
		return "employee-form";
	}
	
	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm(@RequestParam("id") int id ,Model model)
	{
		
		return "redirect:/EMS/getAllEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") int lastName,@RequestParam("email") String email) {
		log.info("EmployeeController saveEmployee()");

		return "redirect:/EMS/getAllEmployee";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id)
	{
		employeeService.deleteById(id);
		return "redirect:/EMS/getAllEmployee";
	}
	
}
