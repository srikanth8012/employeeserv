package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmplyeeService {

	
	Employee employeeGetById(int id);
	
	public Employee createEmployee(Employee employee);
} 
