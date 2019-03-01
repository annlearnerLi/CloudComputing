package com.csye6225.yanling.courseservice.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.yanling.courseservice.datamodel.Course;
import com.csye6225.yanling.courseservice.datamodel.Lecture;
import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Student;
import com.csye6225.yanling.courseservice.service.ProfessorsService;

//.. /webapi/myresource
@Path("courses")
public class CourseResource {
	CourseResource courseService = new CourseResource();
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Professor> getProfessors() {
//		return profService.getAllProfessors();
//	}	
	

	 // ... webapi/professor/1 
	 @GET
	 @Path("/{courseId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String getProfessor(@PathParam("courseId") int courseId) {
	  System.out.println("Professor Resource: Looking for: " + courseId);
	  return "who";
	//  return profService.getProfessor(profId);
	 }

	
	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseId") int courseId) {
		return courseService.deleteCourse(courseId);
	}
	 


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
			course.setCourseId(course.getCourseId());
			//prof.setId(prof.getProfessorId());
			return courseService.addCourse(course);
	}
	
//	@PUT
//	@Path("/{professorId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Professor updateProfessor(@PathParam("professorId") long profId, 
//			Professor prof) {
//		return profService.updateProfessorInformation(profId, prof);
//	}
	
	public void addCourse(int CourseID,
			  			  List<Lecture> lectureList,
			  			  String board,
			  			  List<String> roster,
			  			  List<Student> enrolledStudent,
			  			  Professor associatedProfessor,
			  			  Student TA) {
		courseService.addCourse(CourseID,
	  			               lectureList,
	  			                board,
	  			                roster,
	  			                enrolledStudent,
	  			                associatedProfessor,
	  			                TA);
	}
}
