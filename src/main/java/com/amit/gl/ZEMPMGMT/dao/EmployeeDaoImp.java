package com.amit.gl.ZEMPMGMT.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amit.gl.ZEMPMGMT.entity.Employee;

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
	        // Get the current Hibernate session
	        Session currentSession = entityManager.unwrap(Session.class);
	        
	        Query query = currentSession.createQuery("from Employee", Employee.class);
	        List<Employee> employees = query.getResultList();
	        
	        return employees;
	    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee employee) {
        // Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        currentSession.saveOrUpdate(employee);
    }


    @Override
    @Transactional
    public Employee findById(int id) {
        // Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        Employee employee = currentSession.get(Employee.class, id);
        
        return employee;
    }

    @Override
    @Transactional
    public void deleteById(int id)
    {
    	Session session = entityManager.unwrap(Session.class);
    	
    	Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
