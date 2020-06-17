package com.idiot.exam.dao;

import com.idiot.exam.domain.ExamManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExamManageDao {
    @Select("select * from exam_manage")
    List<ExamManage> findAll();


    @Select("select * from exam_manage where examCode = #{examCode}")
    ExamManage findByExamCode(Integer examCode);


}
