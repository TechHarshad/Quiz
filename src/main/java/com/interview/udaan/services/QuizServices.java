package com.interview.udaan.services;

import com.interview.udaan.entity.Questions;
import com.interview.udaan.entity.Quiz;
import com.interview.udaan.entity.QuizSubmition;
import com.interview.udaan.entity.SubmitQuestion;
import com.interview.udaan.exceptions.CustomExceptions;
import com.interview.udaan.repository.QuestionRepository;
import com.interview.udaan.repository.QuizRepository;
import com.interview.udaan.repository.QuizSubmitionRepository;
import com.interview.udaan.util.UdaanUtillity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuizServices {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizSubmitionRepository quizSubmitionRepository;


    public Questions addQuestion(Questions questions) {

        if(questionRepository.getQuestionsRepo().containsKey(questions.getQuestionId())){
            throw new CustomExceptions("Question already present");
        }
        questionRepository.getQuestionsRepo().put(questions.getQuestionId(), questions);
        return questions;
    }


    public Quiz addQuiz(String quizName, String quizDesc, List<String> questionIdList) {

        List<Questions> questionList = fetchQuestionList(questionIdList);

        Quiz quiz = new Quiz(UUID.randomUUID().toString(), quizName, quizDesc, questionList);
        quizRepository.getQuizRepo().put(quiz.getQuizId(), quiz);
        return quiz;
    }

    public List<Questions> fetchQuestionList(List<String> questionIdList){
        List<Questions> questionsList = new ArrayList<>();
        for(String questionId : questionIdList){
            if(!questionRepository.getQuestionsRepo().containsKey(questionId)){
                throw new CustomExceptions("Invalid QuestionId, Quiz Creation failed due to Invalid Question id : "+ questionId);
            }
            questionsList.add(questionRepository.getQuestionsRepo().get(questionId));
        }

        return  questionsList;
    }

    public QuizSubmition submitQuiz(String quizId, List<SubmitQuestion> submitQuestionList) {
        List<Questions> quizQuestions;

        if(!quizRepository.getQuizRepo().containsKey(quizId)){
            throw new CustomExceptions("Invalid Quiz Id");
        }

        quizQuestions = quizRepository.getQuizRepo().get(quizId).getQuestionsList();

        for(SubmitQuestion submitQuestion : submitQuestionList){
            if(!questionRepository.getQuestionsRepo().containsKey(submitQuestion.getQuestionId())
                    || !quizQuestions.contains(questionRepository.getQuestionsRepo().get(submitQuestion.getQuestionId()))){
                throw new CustomExceptions("Invalid Question submitted");
            }
        }

        QuizSubmition quizSubmition = new QuizSubmition(UUID.randomUUID().toString(),
                quizId, submitQuestionList, null);

        return quizSubmition;
    }

    public List<Questions> getQuizQuestionsList(String quizId, int page) {
        List<Questions> quizQuestions;
        int initial = (page * UdaanUtillity.DEFAULT_PAGESIZE) - 1;
        int last = initial + UdaanUtillity.DEFAULT_PAGESIZE;

        if(!quizRepository.getQuizRepo().containsKey(quizId)){
            throw new CustomExceptions("Invalid Quiz Id");
        }

        quizQuestions = quizRepository.getQuizRepo().get(quizId).getQuestionsList();

        for(int i = initial; i < last; i++ ){

        }

        return null;
    }
}
