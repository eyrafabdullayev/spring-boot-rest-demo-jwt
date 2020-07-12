package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> studentList = Arrays.asList(
            new Student(1, "Kenan")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public Student getStudents(@PathVariable("studentId") Integer id) {
        return studentList.get(id - 1);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public void updateStudent(@RequestBody Student student) {
        System.out.println(student + " --- Updated");
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public void registerStudent(@RequestBody Student student) {
        System.out.println(student + " --- Added");
    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("student --- Deleted");
    }
}
