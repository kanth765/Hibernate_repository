package com.ciq.entity;

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
public class Cars {

	@Id
	@GenericGenerator(name = "identity_tab", strategy = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "identity_tab")
	private long cid;
	private String brandName;
	private String colorName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Person> persons;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public long getCid() {
		return cid;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
	

}
