package com.spac.questionnaire.dao;

import com.spac.questionnaire.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao extends JpaRepository<Answer,Integer> {
    List<Answer> findByQuestionId(Integer id);
}
