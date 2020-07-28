package com.paypal.bfs.test.employeeserv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paypal.bfs.test.employeeserv.entity.Address;
import com.paypal.bfs.test.employeeserv.entity.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmplyeeService;
import com.paypal.bfs.test.employeeserv.util.FormateUtill;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest {

	@Autowired
	private EmplyeeService emplyeeService;

	@MockBean
	private EmployeeRepository repository;

	@MockBean
	private FormateUtill formateUtill;

	private DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	@Test
	public void employeeGetByIdTest() throws ParseException {

		Employee employee = new Employee();
		employee.setFirstName("Srikant");
		employee.setLastName("Lakkakula");
		employee.setDob(toDate("06-10-1985"));
		employee.setId(1);
		Address address = new Address();
		address.setLine1("8663 Town And Coutry Blvd");
		address.setLine2("APT E");
		address.setCity("Ellicott City");
		address.setState("Md");
		address.setCounty("Howard Crossing");
		address.setAddressId(2);
		address.setZipCode("21043");
		employee.setAddress(address);

		com.paypal.bfs.test.employeeserv.api.model.Employee expected = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		expected.setFirstName("Srikant");
		expected.setLastName("Lakkakula");
		expected.setDob("06-10-1985");
		expected.setId(1);
		com.paypal.bfs.test.employeeserv.api.model.Address address2 = new com.paypal.bfs.test.employeeserv.api.model.Address();
		address2.setLine1("8663 Town And Coutry Blvd");
		address2.setLine2("APT E");
		address2.setCity("Ellicott City");
		address2.setState("Md");
		address2.setCounty("Howard Crossing");
		address2.setAddressId(2);
		address2.setZipCode("21043");
		expected.setAddress(address2);

		Mockito.when(repository.findById(Mockito.any(Integer.class))).thenReturn(employee);
		com.paypal.bfs.test.employeeserv.api.model.Employee result = emplyeeService.employeeGetById(1);
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
		assertEquals(expected.getDob(), result.getDob());
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getAddress().getAddressId(), result.getAddress().getAddressId());
		assertEquals(expected.getAddress().getLine1(), result.getAddress().getLine1());
		assertEquals(expected.getAddress().getLine2(), result.getAddress().getLine2());
		assertEquals(expected.getAddress().getCity(), result.getAddress().getCity());
		assertEquals(expected.getAddress().getZipCode(), result.getAddress().getZipCode());
		assertEquals(expected.getAddress().getCounty(), result.getAddress().getCounty());
		assertEquals(expected.getAddress().getState(), result.getAddress().getState());

	}

	@Test
	public void employeeGetByIdTest2() throws ParseException {
		Mockito.when(repository.findById(Mockito.any(Integer.class))).thenReturn(null);
		com.paypal.bfs.test.employeeserv.api.model.Employee result = emplyeeService.employeeGetById(1);
		assertNull(result);
	}

	@Test
	public void createEmployeeTest() throws ParseException {

		Employee employee = new Employee();
		employee.setFirstName("Srikant");
		employee.setLastName("Lakkakula");
		employee.setDob(toDate("06-10-1985"));
		employee.setId(1);
		Address address = new Address();
		address.setLine1("8663 Town And Coutry Blvd");
		address.setLine2("APT E");
		address.setCity("Ellicott City");
		address.setState("Md");
		address.setCounty("Howard Crossing");
		address.setAddressId(2);
		address.setZipCode("21043");
		employee.setAddress(address);

		com.paypal.bfs.test.employeeserv.api.model.Employee input = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		input.setFirstName("Srikant");
		input.setLastName("Lakkakula");
		input.setDob("06-10-1985");
		input.setId(null);
		com.paypal.bfs.test.employeeserv.api.model.Address address2 = new com.paypal.bfs.test.employeeserv.api.model.Address();
		address2.setLine1("8663 Town And Coutry Blvd");
		address2.setLine2("APT E");
		address2.setCity("Ellicott City");
		address2.setState("Md");
		address2.setCounty("Howard Crossing");
		address2.setAddressId(null);
		address2.setZipCode("21043");
		input.setAddress(address2);

		com.paypal.bfs.test.employeeserv.api.model.Employee expected = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		expected.setFirstName("Srikant");
		expected.setLastName("Lakkakula");
		expected.setDob("06-10-1985");
		expected.setId(1);
		com.paypal.bfs.test.employeeserv.api.model.Address expectedAddress = new com.paypal.bfs.test.employeeserv.api.model.Address();
		expectedAddress.setLine1("8663 Town And Coutry Blvd");
		expectedAddress.setLine2("APT E");
		expectedAddress.setCity("Ellicott City");
		expectedAddress.setState("Md");
		expectedAddress.setCounty("Howard Crossing");
		expectedAddress.setAddressId(2);
		expectedAddress.setZipCode("21043");
		expected.setAddress(expectedAddress);

		Mockito.when(repository.save(Mockito.any(Employee.class))).thenReturn(employee);
		com.paypal.bfs.test.employeeserv.api.model.Employee result = emplyeeService.createEmployee(input);
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
		assertEquals(expected.getDob(), result.getDob());
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getAddress().getAddressId(), result.getAddress().getAddressId());
		assertEquals(expected.getAddress().getLine1(), result.getAddress().getLine1());
		assertEquals(expected.getAddress().getLine2(), result.getAddress().getLine2());
		assertEquals(expected.getAddress().getCity(), result.getAddress().getCity());
		assertEquals(expected.getAddress().getZipCode(), result.getAddress().getZipCode());
		assertEquals(expected.getAddress().getCounty(), result.getAddress().getCounty());
		assertEquals(expected.getAddress().getState(), result.getAddress().getState());

	}

	@Test
	public void updateEmployeeTest() throws ParseException {

		Employee employee = new Employee();
		employee.setFirstName("Srikant");
		employee.setLastName("Lakkakula");
		employee.setDob(toDate("06-10-1985"));
		employee.setId(1);
		Address address = new Address();
		address.setLine1("8663 Town And Coutry Blvd");
		address.setLine2("APT E");
		address.setCity("Ellicott City");
		address.setState("Md");
		address.setCounty("Howard Crossing");
		address.setAddressId(2);
		address.setZipCode("21043");
		employee.setAddress(address);

		Employee modified = new Employee();
		modified.setFirstName("Srikant1");
		modified.setLastName("Lakkakula1");
		modified.setDob(toDate("06-10-1985"));
		modified.setId(1);
		Address modifiedAddress = new Address();
		modifiedAddress.setLine1("8663 Town And Coutry Blvd");
		modifiedAddress.setLine2("APT E");
		modifiedAddress.setCity("Ellicott City");
		modifiedAddress.setState("Md");
		modifiedAddress.setCounty("Howard Crossing");
		modifiedAddress.setAddressId(2);
		modifiedAddress.setZipCode("21043");
		modified.setAddress(modifiedAddress);

		com.paypal.bfs.test.employeeserv.api.model.Employee input = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		input.setFirstName("Srikant1");
		input.setLastName("Lakkakula1");
		input.setDob("06-10-1985");
		input.setId(1);
		com.paypal.bfs.test.employeeserv.api.model.Address address2 = new com.paypal.bfs.test.employeeserv.api.model.Address();
		address2.setLine1("8663 Town And Coutry Blvd");
		address2.setLine2("APT E");
		address2.setCity("Ellicott City");
		address2.setState("Md");
		address2.setCounty("Howard Crossing");
		address2.setAddressId(2);
		address2.setZipCode("21043");
		input.setAddress(address2);

		com.paypal.bfs.test.employeeserv.api.model.Employee expected = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		expected.setFirstName("Srikant1");
		expected.setLastName("Lakkakula1");
		expected.setDob("06-10-1985");
		expected.setId(1);
		com.paypal.bfs.test.employeeserv.api.model.Address expectedAddress = new com.paypal.bfs.test.employeeserv.api.model.Address();
		expectedAddress.setLine1("8663 Town And Coutry Blvd");
		expectedAddress.setLine2("APT E");
		expectedAddress.setCity("Ellicott City");
		expectedAddress.setState("Md");
		expectedAddress.setCounty("Howard Crossing");
		expectedAddress.setAddressId(2);
		expectedAddress.setZipCode("21043");
		expected.setAddress(expectedAddress);

		Mockito.when(repository.findById(Mockito.any(Integer.class))).thenReturn(employee);
		Mockito.when(repository.save(Mockito.any(Employee.class))).thenReturn(modified);
		com.paypal.bfs.test.employeeserv.api.model.Employee result = emplyeeService.createEmployee(input);
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
		assertEquals(expected.getDob(), result.getDob());
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getAddress().getAddressId(), result.getAddress().getAddressId());
		assertEquals(expected.getAddress().getLine1(), result.getAddress().getLine1());
		assertEquals(expected.getAddress().getLine2(), result.getAddress().getLine2());
		assertEquals(expected.getAddress().getCity(), result.getAddress().getCity());
		assertEquals(expected.getAddress().getZipCode(), result.getAddress().getZipCode());
		assertEquals(expected.getAddress().getCounty(), result.getAddress().getCounty());
		assertEquals(expected.getAddress().getState(), result.getAddress().getState());

	}

	private Date toDate(String dateString) throws ParseException {

		Date date = null;
		if (StringUtils.isNotEmpty(dateString)) {
			try {
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				throw e;
			}
		}
		return date;
	}

}
