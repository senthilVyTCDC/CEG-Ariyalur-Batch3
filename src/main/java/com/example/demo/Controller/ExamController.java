package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Exam;
import com.example.demo.repository.ExamRepository;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    // POST - Add Exam
    @PostMapping("/add")
    public Exam addExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    // GET - Get All Exams
    @GetMapping("/all")
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // PUT - Update Exam
    @PutMapping("/update/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        exam.setId(id);
        return examRepository.save(exam);
    }

    // DELETE - Delete Exam
    @DeleteMapping("/delete/{id}")
    public String deleteExam(@PathVariable Long id) {
        examRepository.deleteById(id);
        return "Exam Deleted Successfully";
    }
}
