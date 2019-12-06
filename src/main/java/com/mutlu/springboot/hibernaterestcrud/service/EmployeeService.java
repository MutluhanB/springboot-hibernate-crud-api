package com.mutlu.springboot.hibernaterestcrud.service;

import java.util.List;

import com.mutlu.springboot.hibernaterestcrud.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findByID(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
