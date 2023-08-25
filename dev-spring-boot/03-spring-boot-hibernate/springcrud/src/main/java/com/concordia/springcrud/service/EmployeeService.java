package com.concordia.springcrud.service;

import java.util.List;


import com.concordia.springcrud.entity.Employee;

// di connects to interface
public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
