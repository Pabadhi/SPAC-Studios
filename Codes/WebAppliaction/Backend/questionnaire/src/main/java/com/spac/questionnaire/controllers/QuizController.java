package com.spac.questionnaire.controllers;

import com.spac.questionnaire.models.Feedback;
import com.spac.questionnaire.models.FeedbackResult;
import com.spac.questionnaire.models.QuestionWrapper;
import com.spac.questionnaire.models.Response;
import com.spac.questionnaire.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @GetMapping("get")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(){
        return quizService.getQuiz();
    }

    @PostMapping("submit")
    public ResponseEntity<FeedbackResult> submitQuiz(@RequestBody List<Response> responses){
        return quizService.generateFeedback(responses);
    }
}
