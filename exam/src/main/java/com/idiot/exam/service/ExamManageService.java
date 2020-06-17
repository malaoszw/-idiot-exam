package com.idiot.exam.service;

import com.idiot.exam.domain.ExamManage;

import java.util.List;

public interface ExamManageService {
    List<ExamManage> findAll();
    ExamManage findByExamCode(Integer examCode);
}
