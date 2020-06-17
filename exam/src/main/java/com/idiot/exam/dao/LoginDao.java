package com.idiot.exam.dao;

import com.idiot.exam.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginDao {
    @Select("select id,password,status from student where username=#{username} ")
    public Student studentLogin(String username);
}