package com.csye6225.yanling.courseservice.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Student;
import com.csye6225.yanling.courseservice.service.StudentService;
import com.csye6225.yanling.courseservice.service.SystemService;

@Path("students")
public class StudentResource {
	StudentService service = new StudentService();
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Student> getStudents() {
	  return service.getAllStudents();
	 }
	
	 @GET
	 @Path("/{studentId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Student getStudent(@PathParam("studentId") String stuID) {
		 System.out.println("Student Resource: Looking for: " + stuID);
		 return service.getStudent(stuID);
	 }
	 
	 @DELETE
	 @Path("/{studentId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Student deleteStudent(@PathParam("studentId") String stuID) {
		return service.deleteStudent(stuID);
	 }
	 
	 @PUT
	 @Path("/{studentId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Student updateProfessor(@PathParam("studentId") String stuID, 
	   Student student) {
	  return service.updateStudentInformation(stuID, student);
	 }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Student addStudent(Student stu) {
	   stu.setStudentId(stu.getFirstName() + stu.getLastName());
	   return service.addStudent(stu);
	   
	 }
}
