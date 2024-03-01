package com.amit.gl.ZEMPMGMT.dao;

import java.util.List;

import com.amit.gl.ZEMPMGMT.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void saveOrUpdate(Employee employee);

	public void deleteById(int id);
}
