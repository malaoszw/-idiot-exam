package com.idiot.exam.service.impl;

import com.idiot.exam.dao.AnswerDao;
import com.idiot.exam.domain.Answer;
import com.idiot.exam.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerDao answerDao;
    @Override
    public int add(Answer answer) {
        return answerDao.add(answer);
    }

    @Override
    public List<Answer> findByUserIdAndExamCode(Integer studentId, Integer examCode) {
        return answerDao.findByUserIdAndExamCode(studentId,examCode);
    }


    @Override
    public List<Answer> findAll() {
        return null;
    }

    @Override
    public Answer findUserAnswerByUserIdAndExamCode(Integer studentId, Integer examCode) {
        return answerDao.findUserAnswerByUserIdAndExamCode(studentId,examCode);
    }

    @Override//计算已经插入的试卷答题数
    public int findCountByUserIdAndExamCode(Integer studentId, Integer examCode) {
        return answerDao.findCountByUserIdAndExamCode(studentId,examCode);
    }

    @Override
    public List<Answer> findAnswerId() {
        return answerDao.findAnswerId();
    }

    @Override
    public int updateScore(Integer score,Integer answerId) {
        return answerDao.updateScore(score,answerId);
    }

    @Override
    public int findTotalScoreByUserIdAndExamCode(Integer studentId, Integer examCode) {
        return answerDao.findTotalScoreByUserIdAndExamCode(studentId,examCode);
    }
}
