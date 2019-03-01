package com.csye6225.yanling.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.yanling.courseservice.datamodel.Program;
import com.csye6225.yanling.courseservice.datamodel.Student;



public class ProgramService {
static HashMap<Long, Program> programs = SystemService.programs;

public List<Program> getAllPrograms() {
	  List<Program> list = new ArrayList<>();
	  for (Program prog : programs.values()) {
	  }
	  return list ;
}
	
	public Program getProgram(String progID) {
		return programs.get(progID);
	}
	
	public Program deleteProgram(String progName) {
		Program one = programs.get(progName);
		programs.remove(progName);
		return one;
	}
	
	public Program updateProgramInformation(String proID, Program program) {
		Program oldprogram = programs.get(Long.parseLong(proID));
		if(oldprogram != null) {
			oldprogram.update(program);
		}
		return oldprogram;
	}
	
	public Program addProgram(Program prog) {
		long nextAvailableID = programs.size() + 1;
		return programs.put(nextAvailableID, prog);
	}
}
