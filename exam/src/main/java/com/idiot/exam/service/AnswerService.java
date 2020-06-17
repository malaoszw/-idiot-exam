package com.idiot.exam.service;

import com.idiot.exam.domain.Answer;

import java.util.List;

public interface AnswerService {

    int add(Answer answer);
    List<Answer> findByUserIdAndExamCode(Integer studentId,Integer examCode);
    List<Answer> findAll();
    Answer findUserAnswerByUserIdAndExamCode(Integer studentId,Integer examCode);
    int findCountByUserIdAndExamCode(Integer studentId,Integer examCode);
    List<Answer> findAnswerId();
    int updateScore(Integer score,Integer answerId);
    int findTotalScoreByUserIdAndExamCode(Integer studentIdd,Integer examCode);
}
