package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", "A"), new Student(2, "Martin", "B")
    ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/do-get-csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
