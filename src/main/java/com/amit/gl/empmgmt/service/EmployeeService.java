package com.amit.gl.empmgmt.service;

import java.util.List;

import com.amit.gl.empmgmt.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void saveOrUpdate(Employee employee);
	public void deleteById(int id);
}
