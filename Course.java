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
@Table(name = "Course")
public class Course {

	@Id
	@Column(name = "CourseId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	@Column(name = "CourseName")
	private String courseName;
	@Column(name = "CourseDescription")
	private String courseDesc;
	@Column(name = "Semester")
	private String semester;
	@Column(name = "Location")
	private String location;
	
	@OneToMany(mappedBy = "courseMap")
	List<SCMapping> courseMapList;
	
	public List<SCMapping> getCourseMapList() {
		return courseMapList;
	}
	public void setCourseMapList(List<SCMapping> courseMapList) {
		this.courseMapList = courseMapList;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
