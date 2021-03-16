package org.quarkus.example.controller;

import org.quarkus.example.model.Student;
import org.quarkus.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class QuarkusExampleApplication {

    private static final Logger LOG = LoggerFactory.getLogger(QuarkusExampleApplication.class);

    private StudentService studentService;

    public QuarkusExampleApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response students() {
        return Response.ok(studentService.getAllStudents()).build();
    }

    @GET()
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response student(@PathParam("id") final String id) {
        return Response.ok(studentService.getStudentById(id)).build();
    }

    @POST
    @Path("/student/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final Student student) {

        LOG.info("Student data request {} to be saved", student);
        final Student savedStudent = studentService.save(student);
        if (null != savedStudent) {
            return Response.status(Response.Status.CREATED)
                    .entity(savedStudent)
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(String.format("Caught Exception while saving the student %s", student))
                    .build();
        }

    }

    @PUT
    @Path("/student/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final Student student, @PathParam("id") final String id) {
        LOG.info("Student data request {} to be updated for id {}", student, id);
        return Response.ok(studentService.update(student, id)).build();
    }

    @DELETE
    @Path("/student/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") final String id) {
        try {
            studentService.remove(id);
        } catch (Exception e) {
            LOG.error("Exception caught while removing the student for the id : {}", id);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(String.format("Exception caught while removing the student for the id : %s", id))
                    .build();
        }
        return Response.status(Response.Status.ACCEPTED)
                .entity(String.format("Student with %s has been removed successfully", id))
                .build();
    }
}