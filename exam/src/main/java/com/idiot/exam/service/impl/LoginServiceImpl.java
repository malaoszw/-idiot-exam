package com.idiot.exam.service.impl;

import com.idiot.exam.dao.LoginDao;
import com.idiot.exam.domain.Student;
import com.idiot.exam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;
    @Override
    public Student studentLogin(String username) {
        return loginDao.studentLogin(username);
    }
}
