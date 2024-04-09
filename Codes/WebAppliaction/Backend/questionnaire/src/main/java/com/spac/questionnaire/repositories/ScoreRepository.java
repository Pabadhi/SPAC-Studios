package com.spac.questionnaire.repositories;

import com.spac.questionnaire.dao.QuizScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<QuizScore,Integer> {
}
