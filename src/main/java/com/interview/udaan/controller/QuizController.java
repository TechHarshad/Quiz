package com.interview.udaan.controller;

import com.interview.udaan.entity.Questions;
import com.interview.udaan.entity.Quiz;
import com.interview.udaan.entity.QuizSubmition;
import com.interview.udaan.entity.SubmitQuestion;
import com.interview.udaan.exceptions.CustomExceptions;
import com.interview.udaan.services.QuizServices;
import com.interview.udaan.util.QuestionType;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/udaan")
public class QuizController {

    @Autowired
    private QuizServices quizServices;

    @PostMapping("/createQuestion")
    public Questions createQuestion(@PathVariable(value = "correctOption") @NonNull final String correctOption,
                                    @PathVariable(value = "options") @NonNull
             final List<String> options,@PathVariable(value = "description")  @NonNull final String description,
                                    @PathVariable(value = "questionType") @NonNull final QuestionType questionType){

        if (!options.contains(correctOption)){
            throw new CustomExceptions("Invalid Correct Option");
        }

        return quizServices.addQuestion(new Questions(UUID.randomUUID().toString(), description, questionType, options, correctOption));
    }

    @PostMapping("/CreateQuiz")
    public Quiz createQuiz(@NonNull final String quizName, @NonNull final String quizDesc,
                           @NonNull List<String> questionIdList){
        return quizServices.addQuiz(quizName, quizDesc, questionIdList);
    }

    @PostMapping("/SubmitQuiz")
    public QuizSubmition submitQuiz(@NonNull final String quizId ,@NonNull final List<SubmitQuestion> submitQuestionList){
        return quizServices.submitQuiz(quizId, submitQuestionList);
    }

    @PostMapping("/GetQuizQuestionList")
    public void getQuizQuestionList(@NonNull final String quizId, @NonNull final int page){
        quizServices.getQuizQuestionsList(quizId, page);
    }

}
