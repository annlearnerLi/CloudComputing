package com.csye6225.yanling.courseservice.datamodel;

import java.util.HashSet;
import java.util.Set;

public class Program {
	Set<Course> courses;
	private final String name;
	
	Program(String name) {
		this.name = name;
		courses = new HashSet<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void update(Program p) {
		if(p != null) {
			if(p.courses != null) {
				this.courses.addAll(p.courses);
			}
		}
	}
}
