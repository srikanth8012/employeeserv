package com.paypal.bfs.test.employeeserv.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.Address;
import com.paypal.bfs.test.employeeserv.util.FormateUtill;
 

@Mapper(uses = FormateUtill.class)
public interface EmployeeMapper {

	public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

	@BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	//@Mappings({ @Mapping(target = "address", expression = "java(null)") })
	@Mapping(target = "dob", source = "dob")
	com.paypal.bfs.test.employeeserv.entity.Employee voToDomain(Employee t);

	@Mapping(target = "dob", source = "dob")
	@Mapping(target = "additionalProperties", ignore = true)
	Employee domainToVo(com.paypal.bfs.test.employeeserv.entity.Employee t);

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	@Mapping(target = "additionalProperties", ignore = true)
	com.paypal.bfs.test.employeeserv.api.model.Address domainToVoAdress(Address dataList);

	@BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	@Mapping(target = "employee", ignore = true)
	Address voTodomainAddress(com.paypal.bfs.test.employeeserv.api.model.Address t);
	
	



}
