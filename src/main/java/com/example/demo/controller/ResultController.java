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

import com.example.demo.entity.Result;
import com.example.demo.repository.ResultRepository;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/add")
    public Result addResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    @GetMapping("/all")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result result) {
        result.setId(id);
        return resultRepository.save(result);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteResult(@PathVariable Long id) {
        resultRepository.deleteById(id);
        return "Result Deleted Successfully";
    }
}

