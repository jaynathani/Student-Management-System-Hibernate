package com.hibernate.proj.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student { //Bean or Pojo hibernate entity class

	@Id														//Showing that StudentId is primary key
	@Column(name = "StudentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//Showing the auto_increment in StudentId
	private Integer studentId;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "Gender")
	private String gender;
	
	@OneToMany(mappedBy = "student")
	List<Address> addressList;
	
	@OneToMany(mappedBy = "studentMap")
	List<SCMapping> studentMapList;
	
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public List<SCMapping> getStudentMapList() {
		return studentMapList;
	}
	public void setStudentMapList(List<SCMapping> studentMapList) {
		this.studentMapList = studentMapList;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
