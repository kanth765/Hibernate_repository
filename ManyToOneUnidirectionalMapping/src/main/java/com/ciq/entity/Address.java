package com.ciq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Address {

	@Id
	@GenericGenerator(name = "ad_ide_tab", strategy = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ad_ide_tab")
	private long aid;

	private String city;
	private String state;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, Person person) {
		this.city = city;
		this.state = state;
		this.person = person;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getAid() {
		return aid;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", state=" + state + ", person=" + person + "]";
	}

}
