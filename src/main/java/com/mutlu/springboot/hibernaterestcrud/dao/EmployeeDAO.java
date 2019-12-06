package com.mutlu.springboot.hibernaterestcrud.dao;

import java.util.List;
import com.mutlu.springboot.hibernaterestcrud.entity.Employee;

public interface EmployeeDAO {

public List<Employee> findAll();
public Employee findById(int theId);
public void save(Employee theEmployee);
public void deleteById(int theId);

}
