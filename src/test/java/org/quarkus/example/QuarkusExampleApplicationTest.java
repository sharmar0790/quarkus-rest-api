package org.quarkus.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.quarkus.example.model.Student;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class QuarkusExampleApplicationTest {

    @Test
    public void testStudentsEndpoint() {
        given()
                .when().get("/api/students")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testStudentSaveEndpoint() throws Exception {
        final Student student = new Student();
        student.setHobbies("Cricket");
        student.setName("Katya");
        given()
                .when()
                .body(student)
                //.accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .post("/api/student/save")
                .then()
                .statusCode(201)
                .body(notNullValue());
    }

}