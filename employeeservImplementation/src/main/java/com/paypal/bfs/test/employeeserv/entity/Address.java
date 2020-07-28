package com.paypal.bfs.test.employeeserv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "emp_address")
public class Address {

	/**
	 * address addressId
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;

	/**
	 * address line1 (Required)
	 * 
	 */
	@Column(name = "line_1", length = 50, nullable = false, unique = false)
	private String line1;

	/**
	 * address line2
	 * 
	 */
	@Column(name = "line_2", length = 255, nullable = true, unique = false)
	private String line2;

	/**
	 * city (Required)
	 * 
	 */
	@Column(name = "city", length = 50, nullable = false, unique = false)
	private String city;

	/**
	 * state (Required)
	 * 
	 */
	@Column(name = "state", length = 50, nullable = false, unique = false)
	private String state;

	/**
	 * county (Required)
	 * 
	 */
	@Column(name = "county", length = 50, nullable = false, unique = false)
	private String county;

	/**
	 * zipCode (Required)
	 * 
	 */
	@Column(name = "zip_code", length = 10, nullable = false, unique = false)
	private String zipCode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private Employee employee;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
