package org.quarkus.example.repository;

import org.quarkus.example.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class StudentRepository {

    private static final Logger LOG = LoggerFactory.getLogger(StudentRepository.class);

    private Map<String, Student> students = Collections.synchronizedMap(new LinkedHashMap<>());


    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Student getStudentById(final String id) {
        return students.get(id);
    }

    public void remove(final String id) {
        students.remove(id);
    }

    public Student save(@Valid final Student student) {
        try {
            final String id = UUID.randomUUID().toString();
            student.setId(id);
            students.put(id, student);
            return student;
        } catch (Exception e) {
            LOG.error("Exception caught while saving the student : {}", student);
        }
        return null;
    }

    public String update(@Valid final Student student, final String id) {
        try {
            students.put(id, student);
            return String.format("Student updated successfully with id : %s", id);
        } catch (Exception e) {
            LOG.error("Exception caught while updating the student : {} with id : {}", student, id);
        }
        return String.format("Exception caught while updating the student : %s with id : %s", student, id);
    }
}
