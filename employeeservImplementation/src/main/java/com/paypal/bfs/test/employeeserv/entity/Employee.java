package com.paypal.bfs.test.employeeserv.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "employee_details")
public class Employee {

	/**
	 * employee id
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * first name (Required)
	 * 
	 */
	@Column(name = "first_name", length = 50, nullable = false, unique = false)
	private String firstName;

	/**
	 * last name (Required)
	 * 
	 */
	@Column(name = "last_name", length = 50, nullable = false, unique = false)
	private String lastName;

	/**
	 * date of birth (Required)
	 * 
	 */
	@Column(name = "dob", nullable = false, unique = false)
	private Date dob;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	private Address address;

	public void addAddress(Address address) {
		if (null != address) {
			address.setEmployee(this);
			this.address = address;
		} else
			return;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
