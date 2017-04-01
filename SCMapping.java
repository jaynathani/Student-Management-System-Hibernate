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
@Table(name = "Student_Course_Mapping ")
public class SCMapping {

	@Id
	@Column(name = "RegistrationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regId;
	
	@ManyToOne
	@JoinColumn(name = "StudentId")
	Student studentMap;
	
	@ManyToOne
	@JoinColumn(name = "CourseId")
	Course courseMap;

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Student getStudentMap() {
		return studentMap;
	}

	public void setStudentMap(Student studentMap) {
		this.studentMap = studentMap;
	}

	public Course getCourseMap() {
		return courseMap;
	}

	public void setCourseMap(Course courseMap) {
		this.courseMap = courseMap;
	}
	
	
}
