package com.ciq.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "persons" ,cascade = CascadeType.ALL)
	private List<Cars> cars;

	public long getPid() {
		return pid;
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

	public List<Cars> getCars() {
		return cars;
	}

	public void setCars(List<Cars> cars) {
		this.cars = cars;
	}

}
