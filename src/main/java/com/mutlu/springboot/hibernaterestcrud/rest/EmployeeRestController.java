package com.mutlu.springboot.hibernaterestcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutlu.springboot.hibernaterestcrud.dao.EmployeeDAO;
import com.mutlu.springboot.hibernaterestcrud.entity.Employee;
import com.mutlu.springboot.hibernaterestcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findALl(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findByID(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("EmployeeId not found ! ");
		}
		
		return theEmployee;
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {	
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tmpemp = employeeService.findByID(employeeId);
		if(tmpemp == null) {
			throw new RuntimeException();
		}
		employeeService.deleteById(employeeId);
		return "Deleted" + employeeId;
	}
	
	
	
}
