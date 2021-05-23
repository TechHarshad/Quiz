package com.interview.udaan.entity;

import com.interview.udaan.util.QuestionType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Questions {
    private String questionId;
    private String question;
    private QuestionType questionType;
    private List<String> options;
    private String correctOption;
    private LocalDateTime createdOn;

    public Questions(String questionId, String question, QuestionType questionType, List<String> options, String correctOption) {
        this.questionId = questionId;
        this.question = question;
        this.questionType = questionType;
        this.options = options;
        this.correctOption = correctOption;
        this.createdOn = LocalDateTime.now();
    }


}
