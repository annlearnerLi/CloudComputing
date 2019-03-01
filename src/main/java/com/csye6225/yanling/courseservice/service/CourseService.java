package com.csye6225.yanling.courseservice.service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.csye6225.yanling.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.yanling.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.yanling.courseservice.datamodel.Lecture;
import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Student;
import com.csye6225.yanling.courseservice.datamodel.Course;

public class CourseService {
	static HashMap<Long, Course> course_Map = InMemoryDatabase.getCourseDB();
	
	public CourseService() {
	}
	
	// Getting a list of all professor 
	// GET "..webapi/professors"
	public List<Course> getAllProfessors() {	
		//Getting the list
		ArrayList<Course> list = new ArrayList<>();
		for (Course course : course_Map.values()) {
			list.add(course);
		}
		return list ;
	}

	// Adding a Course
	public void addCourse(int CourseID, List<Lecture> lectureList, String board, List<String> roster,
            			  List<Student> enrolledStudent, Professor associatedProfessor, Student TA) {
		// Next Id 
		 long nextAvailableId = course_Map.size() + 1;
		
		//Create a Professor Object
		Course course = new Course(CourseID, lectureList, board, roster, enrolledStudent, associatedProfessor, TA);
		
		course_Map.put(nextAvailableId, course);
	}
	
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		long nextAvailableId = course_Map.size() + 1;
		course_Map.put(nextAvailableId, course);
		course_Map.put(nextAvailableId, course);
		return course;
	}
	
	
	// Getting One Professor
	public Course getCourse(Course CourseId) {
		
		 //Simple HashKey Load
		 Course cur = course_Map.get(CourseId);
	     System.out.println("Item retrieved:");
	     System.out.println(cur.toString());
		 return cur;
	}
	
	// Deleting a course
	public Course deleteProfessor(int courseId) {
		Course deletedCourse = course_Map.get(courseId);
		course_Map.remove(courseId);
		return deletedCourse;
	}
	
	// Updating Course Info
	public Course updateCourseInformation(int courseId, Course course) {	
		Course oldCourseObject = course_Map.get(courseId);
		courseId = oldCourseObject.getCourseId();
		course.setCourseId(courseId);
		return course;
	}
	
//	public Professor updateProfessorInformation(long profId, Professor prof) {
//		// TODO Auto-generated method stub
//		Professor oldProfObject = prof_Map.get(profId);
//		String curId = oldProfObject.getProfessorId();
//		prof.setProfessorId(curId);
//		return prof;
//	}
//	
//	// Get professors in a department 
//	public List<Professor> getProfessorsByDepartment(String department) {	
//		//Getting the list
//		ArrayList<Professor> list = new ArrayList<>();
//		for (Professor prof : prof_Map.values()) {
//			if (prof.getDepartment().equals(department)) {
//				list.add(prof);
//			}
//		}
//		return list ;
//	}


}
