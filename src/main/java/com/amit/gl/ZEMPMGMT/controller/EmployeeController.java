package com.amit.gl.ZEMPMGMT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("employee", emp);
		return "employee-list";
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		log.info("EmployeeController addEmployee()");
		Employee newEmployee = new Employee();
		model.addAttribute("employee", newEmployee);
//		employeeService.saveOrUpdate(newEmployee);
		return "employee-form";
	}
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployeeForm(@PathVariable int id ,Model model)
	{
		log.info("EmployeeController updateEmployeeForm() id"+id);

		Employee updatedEmployee = employeeService.findById(id);
		model.addAttribute("employee", updatedEmployee);
		return "Employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,@RequestParam("email") String email) {
		log.info("EmployeeController saveEmployee()");
		
		Employee employee;
		if(id!=0) {
			employee = employeeService.findById(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
		}
		else {
			employee = new Employee(id,firstName,lastName,email);
		}
		employeeService.saveOrUpdate(employee);
		return "redirect:/EMS/getAllEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteById(id);
		return "redirect:/EMS/getAllEmployee";
	}
	
}
