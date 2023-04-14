package com.ciq.model;

public class Employee {

	private long id;
	private String name;
	private double salary;
	private String email;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String name, double salary, String email) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
	}

	
	public Employee(String name, double salary, String email) {
		this.name = name;
		this.salary = salary;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
