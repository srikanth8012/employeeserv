package com.paypal.bfs.test.employeeserv.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Interface for employee resource operations.
 */

public interface EmployeeResource {

	/**
	 * Retrieves the {@link Employee} resource by id.
	 *
	 * @param id employee id.
	 * @return {@link Employee} resource.
	 */
	
	ResponseEntity<Employee> employeeGetById(@PathVariable("id") int id);

	
	ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);

}
