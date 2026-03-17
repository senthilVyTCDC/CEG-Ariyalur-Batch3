package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Add Student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}



