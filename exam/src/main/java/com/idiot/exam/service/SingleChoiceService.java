package com.idiot.exam.service;

import com.idiot.exam.domain.SingleChoice;

import java.util.List;

public interface SingleChoiceService {
    List<SingleChoice> findByIdAndType(Integer paperId);

    List<SingleChoice> findAll();

    SingleChoice findOnlyQuestionId();

    int add(SingleChoice singleChoice);

    List<Integer> findBySubject(String subject,Integer pageNo);
}
