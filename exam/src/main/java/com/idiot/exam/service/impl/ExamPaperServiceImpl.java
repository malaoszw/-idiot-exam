package com.idiot.exam.service.impl;


import com.idiot.exam.dao.PaperDao;
import com.idiot.exam.domain.ExamPaper;

import com.idiot.exam.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private PaperDao paperDao;
    @Override
    public List<ExamPaper> findAll() {
        return paperDao.findAll();
    }

    @Override
    public List<ExamPaper> findByPaperId(Integer paperId) {
        return paperDao.findByPaperId(paperId);
    }

    @Override
    public int add(ExamPaper examPaper) {
        return 0;
    }
}
