package com.spac.questionnaire.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Feedback {
    private Integer questionId;
    private String generalFeedback;
    private String specificFeedback;

    public Feedback(Integer questionId, String generalFeedback, String specificFeedback) {
        this.questionId = questionId;
        this.generalFeedback = generalFeedback;
        this.specificFeedback = specificFeedback;
    }
}
