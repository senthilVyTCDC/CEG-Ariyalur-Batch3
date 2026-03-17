package com.jvlcode.ExamSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.jvlcode.ExamSystem.entity.Exam;
import com.jvlcode.ExamSystem.repository.ExamRepository;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    // ✅ CREATE
    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    // ✅ READ ALL
    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable int id) {
        return examRepository.findById(id).orElse(null);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable int id, @RequestBody Exam examDetails) {
        Exam exam = examRepository.findById(id).orElse(null);

        if (exam != null) {
            exam.setExamName(examDetails.getExamName());
            exam.setTotalQuestions(examDetails.getTotalQuestions());
            exam.setDuration(examDetails.getDuration());
            return examRepository.save(exam);
        } else {
            return null;
        }
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable int id) {
        examRepository.deleteById(id);
        return "Exam deleted successfully!";
    }
}
