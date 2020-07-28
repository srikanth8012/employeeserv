package com.paypal.bfs.test.employeeserv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmplyeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControleerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmplyeeService emplyeeService;

	@MockBean
	private EmployeeRepository repository;

	public static final Integer APP_ID = 1;

	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void employeeGetByIdTest() throws Exception {
		com.paypal.bfs.test.employeeserv.api.model.Employee mocked = new com.paypal.bfs.test.employeeserv.api.model.Employee();
		mocked.setFirstName("Srikant");
		mocked.setLastName("Lakkakula");
		mocked.setDob("06-10-1985");
		mocked.setId(1);
		com.paypal.bfs.test.employeeserv.api.model.Address address2 = new com.paypal.bfs.test.employeeserv.api.model.Address();
		address2.setLine1("8663 Town And Coutry Blvd");
		address2.setLine2("APT E");
		address2.setCity("Ellicott City");
		address2.setState("Md");
		address2.setCounty("Howard Crossing");
		address2.setAddressId(2);
		address2.setZipCode("21043");

		Mockito.when(emplyeeService.employeeGetById(Mockito.any(Integer.class))).thenReturn(mocked);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bfs/employees/" + APP_ID)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	public void createTest() throws Exception {
		Employee mocked = new Employee();
		mocked.setFirstName("Srikant");
		mocked.setLastName("Lakkakula");
		mocked.setDob("06-10-1985");
		mocked.setId(null);
		com.paypal.bfs.test.employeeserv.api.model.Address address2 = new com.paypal.bfs.test.employeeserv.api.model.Address();
		address2.setLine1("8663 Town And Coutry Blvd");
		address2.setLine2("APT E");
		address2.setCity("Ellicott City");
		address2.setState("Md");
		address2.setCounty("Howard Crossing");
		address2.setAddressId(null);
		address2.setZipCode("21043");
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(mocked);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Employee expected = new Employee();
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

		Mockito.when(emplyeeService.createEmployee(Mockito.any(Employee.class))).thenReturn(expected);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/bfs/employees/create")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		
		
	}

}