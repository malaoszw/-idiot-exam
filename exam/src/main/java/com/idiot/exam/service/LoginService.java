package com.idiot.exam.service;

import com.idiot.exam.domain.Student;
import org.springframework.stereotype.Service;


public interface LoginService {
    public Student studentLogin(String username);
}
