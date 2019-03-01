package com.csye6225.yanling.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
	String id;
	List<String> notes;
	List<String> materials;
	
	Lecture(String id) {
		this.id = id;
		notes = new ArrayList<>();
		materials = new ArrayList<>();
	}
	
	public void addNote(String note) {
		notes.add(note);
	}
	
	public void addMaterial(String material) {
		materials.add(material);
	}
}
