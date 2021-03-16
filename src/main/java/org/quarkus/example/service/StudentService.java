package org.quarkus.example.service;

import org.quarkus.example.model.Student;
import org.quarkus.example.repository.StudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class StudentService {

    @Inject
    StudentRepository studentRepository;

    public Collection<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(final String id) {
        return studentRepository.getStudentById(id);
    }

    public void remove(final String id) {
        studentRepository.remove(id);
    }

    public Student save(final Student student) {
        return studentRepository.save(student);
    }

    public String update(final Student student, final String id) {
        return studentRepository.update(student, id);
    }

}
