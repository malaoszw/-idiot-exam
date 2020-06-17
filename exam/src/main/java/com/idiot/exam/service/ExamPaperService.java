package com.idiot.exam.service;

import com.idiot.exam.domain.ExamPaper;

import java.util.List;

public interface ExamPaperService {
    List<ExamPaper> findAll();
    List<ExamPaper> findByPaperId(Integer paperId);
    int add(ExamPaper examPaper);
}
