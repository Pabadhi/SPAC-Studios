package com.spac.questionnaire.services;

import com.spac.questionnaire.dao.QuizScore;
import com.spac.questionnaire.dao.User;
import com.spac.questionnaire.repositories.ScoreRepository;
import com.spac.questionnaire.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScoreRepository scoreRepository;
    public ResponseEntity<Boolean> isQuizDone() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        if (userEmail == null || userEmail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        Boolean isQuizDone = null;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            isQuizDone = user.isQuizDone();
        }

        return new ResponseEntity<>(isQuizDone, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        if (userEmail == null || userEmail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        Integer score = null;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<QuizScore> scoreOptional =scoreRepository.findById(user.getId());
            if(scoreOptional.isPresent()){
                QuizScore quizScore = scoreOptional.get();
                score = quizScore.getScore();
            }

        }

        return new ResponseEntity<>(score, HttpStatus.OK);

    }
}
