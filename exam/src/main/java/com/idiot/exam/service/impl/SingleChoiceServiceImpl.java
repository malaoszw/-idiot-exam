package com.idiot.exam.service.impl;


import com.idiot.exam.dao.SingleChoiceDao;
import com.idiot.exam.domain.SingleChoice;
import com.idiot.exam.service.SingleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleChoiceServiceImpl implements SingleChoiceService {
    @Autowired
    SingleChoiceDao singleChoiceDao;

    @Override
    public List<SingleChoice> findByIdAndType(Integer paperId) {
        return singleChoiceDao.findByIdAndType(paperId);
    }

    @Override
    public List<SingleChoice> findAll() {
        return singleChoiceDao.findAll();
    }

    @Override
    public SingleChoice findOnlyQuestionId() {
        return singleChoiceDao.findOnlyQuestionId();
    }

    @Override
    public int add(SingleChoice singleChoice) {
        return singleChoiceDao.add(singleChoice);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return singleChoiceDao.findBySubject(subject,pageNo);
    }
}
