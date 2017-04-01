package com.hibernate.proj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "AddId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addId;
	@Column(name = "Address")
	private String address;
	@Column(name = "Country")
	private String country;
	@Column(name = "Zip")
	private String zip;
	
	@ManyToOne
	@JoinColumn(name = "StudentId")			//Foreign Key
	Student student;

	
	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
	
}
