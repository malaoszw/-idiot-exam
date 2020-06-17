package com.idiot.exam.service;

import com.idiot.exam.domain.Answer;
import com.idiot.exam.domain.Score;

import java.util.List;

public interface ScoreService {
    List<Score> findStudentScoreAll(Integer studentId);
    int add(Integer examCode,Integer studentId);
    List<Score> findAll();
    public int update(Score score);
}
