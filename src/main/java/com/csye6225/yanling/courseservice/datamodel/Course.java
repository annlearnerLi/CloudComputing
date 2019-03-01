package com.csye6225.yanling.courseservice.datamodel;

import java.util.List;

public class Course {
	int courseId;
	List<Lecture> lectureList;
    String board;
    List<String> roster;
    List<Student> enrolledStudent;
    Professor associatedProfessor;
    Student TA;
    public Course() {
    	
    }
    public Course(int CourseID,
    			  List<Lecture> lectureList,
    			  String board,
                  List<String> roster,
                  List<Student> enrolledStudent,
                  Professor associatedProfessor,
                  Student TA) {
    	this.courseId= courseId;
    	this.lectureList = lectureList;
        this.board = board;
        this.roster = roster;
        this.enrolledStudent = enrolledStudent;
        this.associatedProfessor = associatedProfessor;
        this.TA = TA;
    	
    }
    
    public int getCourseId() {
    	return this.courseId;  	
    }
    
    public List<Lecture> getLectureList() {
		return this.lectureList;
	}
	public void addLecture(Lecture lecture) {
		this.lectureList.add(lecture);
	}
	public boolean deleteLecture(Lecture lecture) {
		for(Lecture cur : this.lectureList) {
			if(cur == lecture) {
				lectureList.remove(cur);
				return true;
			}
		}
		return false;
	}
	public List<String> getRoster() {
		return this.roster;
	}
	
	public List<Student> getEnrolledStudent() {
		return this.enrolledStudent;
	}
	
	public boolean addStudent(Student cur) {
		this.enrolledStudent.add(cur);
		this.roster.add(cur.getFirstName() + " " + cur.getLastName());
		return true;
	}
	
	public Professor getAssociatedProfessor() {
		return this.associatedProfessor;
	}
	
	public boolean updateAssociatedProfessor(Professor newProfessor) {
		 this.associatedProfessor = newProfessor;
		 return true;
	}
	
	public Student getStudent() {
		return this.TA;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
	
	
