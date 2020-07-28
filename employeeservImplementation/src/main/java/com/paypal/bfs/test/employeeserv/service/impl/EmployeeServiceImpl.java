package com.paypal.bfs.test.employeeserv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmplyeeService;

@Service
public class EmployeeServiceImpl implements EmplyeeService {

	@Autowired
	EmployeeRepository repository;

	/**
	 * 
	 */
	@Override
	public Employee employeeGetById(int id) {
		com.paypal.bfs.test.employeeserv.entity.Employee employee = repository.findById(id);
		return EmployeeMapper.INSTANCE.domainToVo(employee);

	}

	/**
	 * 
	 */
	@Override
	public Employee createEmployee(Employee employee) {
		Address address = employee.getAddress();
		// This is just to avoid duplicate address persistance.
		if (employee.getId() != null) {
			com.paypal.bfs.test.employeeserv.entity.Employee result = repository.findById(employee.getId());
			address.setAddressId(null != result.getAddress() ? result.getAddress().getAddressId() : null);
		}

		com.paypal.bfs.test.employeeserv.entity.Employee domain = EmployeeMapper.INSTANCE.voToDomain(employee);
		domain.addAddress(EmployeeMapper.INSTANCE.voTodomainAddress(address));
		com.paypal.bfs.test.employeeserv.entity.Employee emp = repository.save(domain);
		return EmployeeMapper.INSTANCE.domainToVo(emp);

	}

}
