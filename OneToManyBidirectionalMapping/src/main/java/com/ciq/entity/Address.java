package com.ciq.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aid;
	private String city;
	private String state;
	private String zipCode;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, String zipCode, Employee employee) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.employee = employee;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getAid() {
		return aid;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode 
				+ "]";
	}

}
