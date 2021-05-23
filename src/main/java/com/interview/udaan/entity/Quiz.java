package com.interview.udaan.entity;

import com.interview.udaan.util.QuizStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class Quiz {
    private String quizId;
    private String quizName;
    private String quizDescription;
    private LocalDateTime creatonOn;
    @Setter private List<Questions> questionsList;
    private QuizStatus quizStatus;


    public Quiz(String quizId, String quizName, String quizDescription , List<Questions> questionsList) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizDescription = quizDescription;
        this.creatonOn = LocalDateTime.now();
        this.questionsList = questionsList;
        this.quizStatus = QuizStatus.IN_ACTIVE;
    }
}
