package com.csye6225.yanling.courseservice.resources;

import java.util.ArrayList;
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
import com.csye6225.yanling.courseservice.service.ProfessorsService;

// .. /webapi/myresource
@Path("professors")
public class ProfessorsResource {

 ProfessorsService profService = new ProfessorsService();
/*
// @GET
// @Produces(MediaType.APPLICATION_JSON)
// public String getProfessors() {
////  return profService.getAllProfessors();
//	 return "GET !";
// } */
//
//public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
//profService.addProfessor(firstName, lastName, department, joiningDate);
//}
 
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 public List<Professor> getProfessorsByDeparment(
   @QueryParam("department") String department   ) {
  
  if (department == null) {
   return profService.getAllProfessors();
  }
  return profService.getProfessorsByDepartment(department);
  
 }
// 
 // ... webapi/professor/1 
 @GET
 @Path("/{professorId}")
 @Produces(MediaType.APPLICATION_JSON)
 public String getProfessor(@PathParam("professorId") String profId) {
  System.out.println("Professor Resource: Looking for: " + profId);
  return profService.getProfessor(profId).toString();
 }
 
 @DELETE
 @Path("/{professorId}")
 @Produces(MediaType.APPLICATION_JSON)
 public Professor deleteProfessor(@PathParam("professorId") long profId) {
  return profService.deleteProfessor(profId);
 }
 
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public String addProfessor(Professor prof) {
   prof.setProfessorId(prof.getFirstName()+prof.getLastName());
   prof.setJoiningDate(new Date().toString());
   prof.setId(prof.getProfessorId());
   profService.addProfessor(prof);
   return prof.toString();
 }
 
 @PUT
 @Path("/{professorId}")
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public Professor updateProfessor(@PathParam("professorId") String profId, 
   Professor prof) {
  return profService.updateProfessorInformation(profId, prof);
 }
 }