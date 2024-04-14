package com.spac.questionnaire.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Feedback {
    private Integer questionId;
    private Integer correctAnswerId;
    private String generalFeedback;
    private String specificFeedback;

    public Feedback(Integer questionId, Integer correctAnswerId, String generalFeedback, String specificFeedback) {
        this.questionId = questionId;
        this.correctAnswerId = correctAnswerId;
        this.generalFeedback = generalFeedback;
        this.specificFeedback = specificFeedback;
    }
}
