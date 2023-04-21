package com.ciq.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emp_tables")
public class Employee {

	@Id
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "myGenerator")
	private int eid;// 1,2,3,4
	@Column
	private String name;
	@Column
	private double salary;

	@Embedded
	private LeaveTracker leaveTracker;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, double salary, LeaveTracker leaveTracker) {
		this.name = name;
		this.salary = salary;
		this.leaveTracker = leaveTracker;
	}

	public int getId() {
		return eid;
	}

	public void setId(int id) {
		this.eid = id;
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

	public LeaveTracker getLeaveTracker() {
		return leaveTracker;
	}

	public void setLeaveTracker(LeaveTracker leaveTracker) {
		this.leaveTracker = leaveTracker;
	}

	@Override
	public String toString() {
		return "Employee [id=" + eid + ", name=" + name + ", salary=" + salary + ", leaveTracker=" + leaveTracker + "]";
	}

}
