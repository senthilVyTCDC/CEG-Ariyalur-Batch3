package com.jvlcode.ExamSystem.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String examName;
    private int totalQuestions;
    private int duration;

    // Constructor
    public Exam() {
    }

    public Exam(String examName, int totalQuestions, int duration) {
        this.examName = examName;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

