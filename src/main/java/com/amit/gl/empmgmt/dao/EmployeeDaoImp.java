package com.amit.gl.empmgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amit.gl.empmgmt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class EmployeeDaoImp implements EmployeeDao {
	EntityManager entityManager;

	@Autowired
	public EmployeeDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {

	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
