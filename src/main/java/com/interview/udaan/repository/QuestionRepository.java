package com.interview.udaan.repository;

import com.interview.udaan.entity.Questions;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class QuestionRepository {
    Map<String, Questions> questionsRepo;

    public QuestionRepository() {
        this.questionsRepo = new HashMap<>();
    }
}
