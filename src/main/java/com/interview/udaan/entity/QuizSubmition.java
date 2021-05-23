package com.interview.udaan.entity;

import com.interview.udaan.util.QuizResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuizSubmition {
    private String submitId;
    private String quizId;
    private List<SubmitQuestion> submittedQuestions;
    private QuizResult quizResult;
    private LocalDateTime createdOn;

    public QuizSubmition(String submitId, String quizId, List<SubmitQuestion> submittedQuestions, QuizResult quizResult) {
        this.submitId = submitId;
        this.quizId = quizId;
        this.submittedQuestions = submittedQuestions;
        this.quizResult = quizResult;
        this.createdOn = LocalDateTime.now();
    }
}
