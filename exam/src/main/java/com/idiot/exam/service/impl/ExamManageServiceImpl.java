package com.idiot.exam.service.impl;


import com.idiot.exam.dao.ExamManageDao;
import com.idiot.exam.domain.ExamManage;
import com.idiot.exam.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    ExamManageDao examDao;

    @Override
    public List<ExamManage> findAll() {
        return examDao.findAll();
    }

    @Override
    public ExamManage findByExamCode(Integer examCode) {
        return examDao.findByExamCode(examCode);
    }
}
