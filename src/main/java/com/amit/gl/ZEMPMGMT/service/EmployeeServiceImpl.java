package com.amit.gl.ZEMPMGMT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.gl.ZEMPMGMT.dao.EmployeeDao;
import com.amit.gl.ZEMPMGMT.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}
	
}
