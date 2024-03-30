package com.spac.questionnaire.services;

import com.spac.questionnaire.dao.AnswerDao;
import com.spac.questionnaire.dao.QuestionDao;
import com.spac.questionnaire.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    AnswerDao answerDao;
    public ResponseEntity<List<QuestionWrapper>> getQuiz() {
        List<QuestionWrapper> quiz = new ArrayList<>();
        List<Question> allQuestions = questionDao.findAll();
        for(Question q: allQuestions ){
            List<AnswerWrapper> answerWrappers = new ArrayList<>();
            List<Answer> allAnswers = answerDao.findByQuestionId(q.getId());
            for(Answer a: allAnswers){
                AnswerWrapper answerWrapper = new AnswerWrapper(a.getId(),a.getAnswerTitle());
                answerWrappers.add(answerWrapper);
            }

            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(),q.getQuestionTitle(),answerWrappers);
            quiz.add(questionWrapper);
        }

        return new ResponseEntity<>(quiz, HttpStatus.OK);


    }

    public ResponseEntity<FeedbackResult> generateFeedback(List<Response> responses) {
        List<Feedback> feedbackList = new ArrayList<>();
        int score = 0;
        for(Response r: responses){
            Optional<Question> questionOptional = questionDao.findById(r.getQuestionId());
            Optional<Answer> answerOptional = answerDao.findById(r.getAnswerId());

            if (questionOptional.isPresent() && answerOptional.isPresent()){
                Question question = questionOptional.get();
                Answer answer = answerOptional.get();

                if(answer.isCorrect()){
                    score++;
                }

                Feedback feedback = new Feedback(r.getQuestionId(),question.getGeneralFeedback(),answer.getSpecificFeedback());

                feedbackList.add(feedback);

            }

        }

        FeedbackResult feedbackResult = new FeedbackResult(score,feedbackList);
        return new ResponseEntity<>(feedbackResult,HttpStatus.OK);
    }
}
