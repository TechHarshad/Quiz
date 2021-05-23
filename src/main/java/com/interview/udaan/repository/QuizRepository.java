package com.interview.udaan.repository;

import com.interview.udaan.entity.Questions;
import com.interview.udaan.entity.Quiz;
import lombok.CustomLog;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class QuizRepository {
    Map<String, Quiz> quizRepo;

    public QuizRepository() {
        this.quizRepo = new HashMap<>();
    }
}
