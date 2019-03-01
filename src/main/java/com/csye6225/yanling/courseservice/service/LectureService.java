package com.csye6225.yanling.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.yanling.courseservice.datamodel.Lecture;
import com.csye6225.yanling.courseservice.datamodel.Lecture;

public class LectureService {
	static HashMap<Long, Lecture> lectures = new HashMap<>();
	
	public List<Lecture> getAllLectures() {
		  List<Lecture> list = new ArrayList<>();
		  for (Lecture stu : lectures.values()) {
		   list.add(stu);
		  }
		  return list ;
	}
	
	public Lecture getLecture(String lecID) {
		return lectures.get(lecID);
	}
	
	public Lecture deleteLecture(String lecID) {
		Lecture one = lectures.get(lecID);
		lectures.remove(lecID);
		return one;
	}
	
	public Lecture updateLectureInformation(String lecID, Lecture lecture) {
		Lecture oldLecture = lectures.get(lecID);
		if(oldLecture != null) {
//			oldLecture.update(lecture);
		}
		return oldLecture;
	}
	
	public Lecture addLecture(Lecture stu) {
		long nextAvailableID = lectures.size() + 1;
		return lectures.put(nextAvailableID, stu);
	}
}
