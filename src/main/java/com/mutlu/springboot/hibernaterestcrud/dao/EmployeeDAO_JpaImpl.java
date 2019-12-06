package com.mutlu.springboot.hibernaterestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mutlu.springboot.hibernaterestcrud.entity.Employee;


@Repository
public class EmployeeDAO_JpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	
	public EmployeeDAO_JpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	

	@Override
	public Employee findById(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee newEmployee = entityManager.merge(theEmployee);
		
		//update with id from db. so we can get generated id for save/insert.
		newEmployee.setId(newEmployee.getId()); 
		
	}

	@Override
	public void deleteById(int theId) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
		
	}

}
