package com.paypal.bfs.test.employeeserv;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		if(StringUtils.isBlank(employee.getFirstName()))
			errors.rejectValue(employee.getFirstName(), "BadRequest");

	}

}
