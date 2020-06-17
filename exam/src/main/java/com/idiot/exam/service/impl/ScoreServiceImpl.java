package com.idiot.exam.service.impl;

import com.idiot.exam.dao.ScoreDao;
import com.idiot.exam.domain.Answer;
import com.idiot.exam.domain.Score;
import com.idiot.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreDao scoreDao;
    @Override
    public List<Score> findStudentScoreAll(Integer studentId) {
        return scoreDao.findStudentScoreAll(studentId);
    }

    @Override
    public int add(Integer examCode,Integer studentId) {
        return scoreDao.add(examCode,studentId);
    }

    @Override
    public List<Score> findAll() {
        return scoreDao.findAll();
    }

    @Override
    public int update(Score score) {
        return scoreDao.update(score);
    }
}
