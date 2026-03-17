package com.example.demo.controller;


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

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping("/add")
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Answer updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        answer.setId(id);
        return answerRepository.save(answer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
        return "Answer Deleted Successfully";
    }
}

