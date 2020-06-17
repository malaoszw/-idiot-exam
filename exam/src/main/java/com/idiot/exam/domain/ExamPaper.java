package com.idiot.exam.domain;

public class ExamPaper {
    private Integer paperId;
    private Integer questionType;
    private Integer questionId;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public ExamPaper(Integer paperId, Integer questionType, Integer questionId) {
        this.paperId = paperId;
        this.questionType = questionType;
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "paperId=" + paperId +
                ", questionType=" + questionType +
                ", questionId=" + questionId +
                '}';
    }
}
