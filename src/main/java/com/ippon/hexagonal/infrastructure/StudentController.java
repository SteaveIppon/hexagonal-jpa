package com.ippon.hexagonal.infrastructure;

import com.ippon.hexagonal.application.StudentService;
import com.ippon.hexagonal.domain.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
@Tag(name = "Student controller", description = "Student routes")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Get list of student", description = "Allows to get student list")
    public List<Student> getStudentController() {
        return studentService.getStudentService();
    }

    @PostMapping
    @Operation(summary = "Insert student in student list", description = "Allows to insert in student list")
    public void addStudentController(@RequestBody Student student) {
        studentService.addStudentService(student);
    }



}
