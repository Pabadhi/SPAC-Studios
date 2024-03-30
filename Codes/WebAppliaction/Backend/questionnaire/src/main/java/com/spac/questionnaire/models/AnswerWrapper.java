package com.spac.questionnaire.models;

import lombok.Data;


@Data
public class AnswerWrapper {
    private Integer answerId;
    private String answerTitle;

    public AnswerWrapper(Integer answerId, String answerTitle) {
        this.answerId = answerId;
        this.answerTitle = answerTitle;
    }
}
