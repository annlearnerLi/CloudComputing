package com.csye6225.yanling.courseservice.datamodel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


public class Student {
 private String id;
 private String firstName;
 private String lastName;
 private String studentID;
 private Set<Course> courses;
 private String imageURL;
 private String programName;
 
 
 public Student() {
  
 }
 
 public Student(String firstName, 
   String lastName) {
  //this.setId(professorId);
	 this.courses = new HashSet<>();
  this.firstName = firstName;
  this.lastName = lastName;
 }
 
 public void update(Student s) {
	 if( s != null) {
		 if(s.firstName != null) {
			 this.firstName = s.firstName;
		 }
		 if(s.lastName != null) {
			 this.lastName = s.lastName;
		 }
		 if(s.studentID != null) {
			 this.studentID = s.studentID;
		 }
		 if(s.courses != null) {
			 this.courses.addAll(s.courses);
		 }
		 if(s.imageURL != null) {
			 this.imageURL = s.imageURL;
		 }
		 if(s.programName != null) {
			 this.programName = s.programName;
		 }
	 }
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
 
 public void setImageURL(String imageURL) {
  this.imageURL = imageURL;
 }
 public String getImageURL() {
  return this.imageURL;
 }

 public String getStudentId() {
  return studentID;
 }
 public void setStudentId(String studentId) {
  this.studentID = studentID;
 }
 
 public String getProgram() {
  return programName;
 }
 public void setProgram(String programName) {
  this.programName = programName;
 }
 
 public void addCourse(Course course) {
	  this.courses.add(course);
 }
 public void removeCourse(Course course) {
	  this.courses.remove(course);
 }
 public boolean containCourse(Course course) {
	  return this.courses.contains(course);
 }
 
 @Override
 public String toString() { 
  return "StuId=" + getStudentId() + ", firstName=" + getFirstName()
    + ", lastName=" + getLastName() + ", ProgramName=" + getProgram();
 }

 public String getId() {
  return id;
 }
 public void setId(String id) {
  this.id = id;
 }

}