package com.csye6225.yanling.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.csye6225.yanling.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Program;
import com.csye6225.yanling.courseservice.datamodel.Student;

public class SystemService {

	static HashMap<Long, Professor> professors = InMemoryDatabase.getProfessorDB();
	static HashMap<Long, Student> students = InMemoryDatabase.getStudentDB();
	static HashMap<Long, Program> programs = InMemoryDatabase.getProgramDB();
	

	
	public List<Professor> getAllProfessors() {
		  List<Professor> list = new ArrayList<>();
		  for (Professor prof : professors.values()) {
		   list.add(prof);
		  }
		  return list ;
	}

	
	public List<Student> getAllStudents() {
		  List<Student> list = new ArrayList<>();
		  for (Student stu : students.values()) {
		   list.add(stu);
		  }
		  return list ;
	}
	
	public List<Program> getAllPrograms() {
		  List<Program> list = new ArrayList<>();
		  for (Program prog : programs.values()) {
		   list.add(prog);
		  }
		  return list ;
	}
}
