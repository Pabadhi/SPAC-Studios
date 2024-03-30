package com.spac.questionnaire.models;

import lombok.Data;

import java.util.List;

@Data
public class FeedbackResult {
    private Integer score;
    private List<Feedback> feedbackList;

    public FeedbackResult(Integer score, List<Feedback> feedbackList) {
        this.score = score;
        this.feedbackList = feedbackList;
    }
}
