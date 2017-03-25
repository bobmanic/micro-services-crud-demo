package com.satyendra.demo.resources;

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
import javax.ws.rs.core.Response;

import com.satyendra.demo.api.Student;
import com.satyendra.demo.core.StudentService;

@Path("/student")
public class StudentResource {

	private StudentService service;

	public StudentResource(StudentService service) {
		this.service = service;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getAll() {
		List<Student> s = service.getAll();
		if (s != null) {
			return Response.ok().entity(s).build();
		} else {
			return Response.ok().type(MediaType.TEXT_PLAIN).entity("Database empty").build();
		}
	}

	@GET
	@Path("/{rollno:\\d+}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getOne(@PathParam("rollno") int rollno) {
		Student s = service.getOne(rollno);
		if (s != null) {
			return Response.ok().entity(s).build();
		} else {
			return Response.ok().type(MediaType.TEXT_PLAIN).entity("Student with that rollno not found").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response create(Student student) {
		if (student != null) {
			if (service.create(student)) {
				return Response.ok().entity("Created").build();
			} else {
				return Response.ok().entity("Student with that rollno already exists").build();
			}
		} else {
			return Response.ok().entity("Provide a json input {\"rollno\": <rollno>,\"name\":\"<name>\"}").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update(Student student) {
		if (student != null) {
			if (service.update(student)) {
				return Response.ok().entity("Updated").build();
			} else {
				return Response.ok().entity("Student with that rollno not found").build();
			}
		} else {
			return Response.ok().entity("Provide a json input {\"rollno\": <rollno>,\"name\":\"<name>\"}").build();
		}
	}

	@DELETE
	@Path("/{rollno:\\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response delete(@PathParam("rollno") int rollno) {
		if (service.delete(rollno)) {
			return Response.ok().entity("Deleted").build();
		} else {
			return Response.ok().entity("Student with that rollno not found").build();
		}
	}
}
