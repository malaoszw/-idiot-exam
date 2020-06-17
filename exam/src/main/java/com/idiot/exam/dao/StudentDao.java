package com.idiot.exam.dao;

import com.idiot.exam.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentDao {
    @Select("select username,avatar,email,phone,status from student")
    public List<Student> findAll();
    @Select("select username,avatar,email,phone,status from student where id=#{id}")
    public Student findById(Integer id);

}
