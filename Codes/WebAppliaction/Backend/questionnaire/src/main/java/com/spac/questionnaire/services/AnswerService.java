package com.spac.questionnaire.services;

import com.spac.questionnaire.repositories.AnswerDao;
import com.spac.questionnaire.dao.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerDao answerDao;

    public ResponseEntity<List<Answer>> getAllAnswers() {
        return new ResponseEntity<>(answerDao.findAll(), HttpStatus.OK);
    }
}
