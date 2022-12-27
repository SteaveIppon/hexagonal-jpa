package com.ippon.hexagonal.application;

import com.ippon.hexagonal.domain.model.Student;
import com.ippon.hexagonal.infrastructure.secondary.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudentService() {
        return new ArrayList<>(studentRepository.findAll());
    }

    public void addStudentService(Student student) {
        List<Student> emailAlreadyExists = studentRepository.findByEmail(student.getEmail());
        if(emailAlreadyExists.size() > 0)
            throw new IllegalStateException("This mail already exists in database ...");
        studentRepository.save(student);
    }
}
