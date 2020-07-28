package com.paypal.bfs.test.employeeserv.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.ResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.service.EmplyeeService;

/**
 * Implementation class for employee resource.
 */
@RestController
@RequestMapping("/v1/bfs/employees")
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmplyeeService service;

	@Override
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Employee> employeeGetById(@NotNull @PathVariable("id") int id) {
		Employee employee = service.employeeGetById(id);
		if (null != employee)
			return new ResponseEntity<>(employee, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("No Employee found with this id: " + id);
			
	}

	@Override
	@PostMapping(path = "/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee) {

		employee = service.createEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}
