package com.ciq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Person {

	@Id
	@GenericGenerator(name = "identity_tab", strategy = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "identity_tab")
	private long pid;

	private String firstName;

	private String lastName;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
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

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
