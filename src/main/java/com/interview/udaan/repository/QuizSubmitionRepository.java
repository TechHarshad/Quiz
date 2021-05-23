package com.interview.udaan.repository;

import com.interview.udaan.entity.Quiz;
import com.interview.udaan.entity.QuizSubmition;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class QuizSubmitionRepository {

    Map<String, QuizSubmition> quizSubmitRepo;

    public QuizSubmitionRepository() {
        this.quizSubmitRepo = new HashMap<>();
    }
}
