package com.mutlu.springboot.hibernaterestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mutlu.springboot.hibernaterestcrud.dao.EmployeeDAO;
import com.mutlu.springboot.hibernaterestcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAO_JpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findByID(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		 employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}

}
