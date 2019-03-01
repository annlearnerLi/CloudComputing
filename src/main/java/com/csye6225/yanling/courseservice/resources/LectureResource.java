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

import com.csye6225.yanling.courseservice.datamodel.Lecture;
import com.csye6225.yanling.courseservice.service.LectureService;

@Path("class/{courseID}/lecture")
public class LectureResource {
	LectureService service = new LectureService();
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Lecture> getLectures() {
	  return service.getAllLectures();
	 }
	
	 @GET
	 @Path("/{lectureId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Lecture getLecture(@PathParam("lectureId") String lecID) {
		 System.out.println("Lecture Resource: Looking for: " + lecID);
		 return service.getLecture(lecID);
	 }
	 
	 @DELETE
	 @Path("/{lectureId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Lecture deleteLecture(@PathParam("lectureId") String lecID) {
		return service.deleteLecture(lecID);
	 }
	 
	 @PUT
	 @Path("/{lectureId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Lecture updateProfessor(@PathParam("lectureId") String stuID, 
	   Lecture lecture) {
	  return service.updateLectureInformation(stuID, lecture);
	 }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Lecture addLecture(Lecture stu) {
	   //prof.setId(prof.getProfessorId());
	   return service.addLecture(stu);
	   
	 }
}
