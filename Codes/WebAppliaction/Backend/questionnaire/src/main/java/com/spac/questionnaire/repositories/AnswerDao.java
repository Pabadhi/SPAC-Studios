package com.spac.questionnaire.repositories;

import com.spac.questionnaire.dao.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao extends JpaRepository<Answer,Integer> {
    List<Answer> findByQuestionId(Integer id);
}
