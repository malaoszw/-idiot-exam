package com.idiot.exam.dao;

import com.idiot.exam.domain.ExamPaper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PaperDao {
    @Select("select paperId, questionType,questionId from exam_paper")
    List<ExamPaper> findAll();

    @Select("select paperId, questionType,questionId from exam_paper where paperId = #{paperId}")
    List<ExamPaper> findByPaperId(Integer paperId);

    @Insert("insert into exam_paper(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(ExamPaper examPaper);
}