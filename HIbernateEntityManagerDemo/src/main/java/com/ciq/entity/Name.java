package com.ciq.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

	@Column
	private String firsName;
	@Column
	private String lastName;
	
	
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Name(String firsName, String lastName) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Name [firsName=" + firsName + ", lastName=" + lastName + "]";
	}
	
	
	
	
}
