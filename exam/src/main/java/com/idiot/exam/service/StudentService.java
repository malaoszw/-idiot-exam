package com.idiot.exam.service;

import com.idiot.exam.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    public Student findById(Integer id);
}
