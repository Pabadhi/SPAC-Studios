package com.spac.questionnaire.services;

import com.spac.questionnaire.repositories.AnswerDao;
import com.spac.questionnaire.repositories.QuestionDao;
import com.spac.questionnaire.dao.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    AnswerDao answerDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

    }

}
