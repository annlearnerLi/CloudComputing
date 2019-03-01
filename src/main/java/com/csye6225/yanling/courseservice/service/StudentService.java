package com.csye6225.yanling.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.yanling.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Student;

public class StudentService {
	static HashMap<Long, Student> students = SystemService.students;
	
	public List<Student> getAllStudents() {
		  List<Student> list = new ArrayList<>();
		  for (Student stu : students.values()) {
		   list.add(stu);
		  }
		  return list ;
	}
	
	public Student getStudent(String stuID) {
		return students.get(stuID);
	}
	
	public Student deleteStudent(String stuID) {
		Student one = students.get(stuID);
		students.remove(stuID);
		return one;
	}
	
	public Student updateStudentInformation(String stuID, Student student) {
		Student oldStudent = students.get(stuID);
		if(oldStudent != null) {
			oldStudent.update(student);
		}
		return oldStudent;
	}
	
	public Student addStudent(Student stu) {
		long nextAvailableID = students.size() + 1;
		return students.put(nextAvailableID, stu);
	}
}
