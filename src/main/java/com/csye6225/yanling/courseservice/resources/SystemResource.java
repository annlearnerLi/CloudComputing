package com.csye6225.yanling.courseservice.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.yanling.courseservice.datamodel.Professor;
import com.csye6225.yanling.courseservice.datamodel.Program;
import com.csye6225.yanling.courseservice.datamodel.Student;
import com.csye6225.yanling.courseservice.service.SystemService;

@Path("system")
public class SystemResource {
	SystemService service = new SystemService();
    
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Welcome to system!";
    }
	 @GET
	 @Path("/professors")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Professor> getAllProfessors() {
	  return service.getAllProfessors();
	 }
	 
	 @GET
	 @Path("/students")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Student> getAllStuents() {
	  return service.getAllStudents();
	 }
	 
	 @GET
	 @Path("/programs")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Program> getAllPrograms() {
	  return service.getAllPrograms();
	 }
}
