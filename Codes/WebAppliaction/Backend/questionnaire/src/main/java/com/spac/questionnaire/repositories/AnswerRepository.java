package com.spac.questionnaire.repositories;

import com.spac.questionnaire.dao.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    List<Answer> findByQuestionId(Integer id);
}
