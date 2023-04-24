package com.ciq.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollNo;
	private String firstName;
	private String lastName;
	private String email;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Course course;

}
