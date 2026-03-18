package com.jvlcode.ExamSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvlcode.ExamSystem.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}

