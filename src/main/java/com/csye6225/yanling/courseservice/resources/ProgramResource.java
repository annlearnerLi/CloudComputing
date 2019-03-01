package com.csye6225.yanling.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.yanling.courseservice.datamodel.Program;
import com.csye6225.yanling.courseservice.datamodel.Student;
import com.csye6225.yanling.courseservice.service.ProgramService;

@Path("programs")
public class ProgramResource {
	ProgramService service = new ProgramService();
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Program> getStudents() {
	  return service.getAllPrograms();
	 }
	
	
	 @GET
	 @Path("/{programId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Program getProgram(@PathParam("programId") String stuID) {
		 System.out.println("Program Resource: Looking for: " + stuID);
		 return service.getProgram(stuID);
	 }
	 
	 @DELETE
	 @Path("/{programId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Program deleteProgram(@PathParam("programId") String stuID) {
		return service.deleteProgram(stuID);
	 }
	 
	 @PUT
	 @Path("/{programId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Program updateProfessor(@PathParam("programId") String stuID, 
	   Program program) {
	  return service.updateProgramInformation(stuID, program);
	 }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Program addProgram(Program prog) {
	   return service.addProgram(prog);
	   
	 }
}
