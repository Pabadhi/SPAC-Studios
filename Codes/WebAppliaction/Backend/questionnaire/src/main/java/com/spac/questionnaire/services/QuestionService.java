package com.spac.questionnaire.services;

import com.spac.questionnaire.dao.AnswerDao;
import com.spac.questionnaire.dao.QuestionDao;
import com.spac.questionnaire.models.Answer;
import com.spac.questionnaire.models.Question;
import com.spac.questionnaire.models.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;

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
