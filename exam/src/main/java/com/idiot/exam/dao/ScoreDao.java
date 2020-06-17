package com.idiot.exam.dao;

import com.idiot.exam.domain.Answer;
import com.idiot.exam.domain.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ScoreDao {
    @Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(examCode,studentId,subject) values" +
            "(#{examCode},#{studentId},(select subject from exam_manage where examCode=#{examCode}))")
    int add(Integer examCode,Integer studentId);

    @Select("select * from score")
    List<Score> findAll();

    @Select("select * from score where studentId=#{studentId}")
    List<Score> findStudentScoreAll(Integer studentId);

    @Update("update score set totalScore=(select sum(score) from  answer where studentId=#{studentId} and examCode=#{examCode}) where scoreId=#{scoreId}")
    public int update(Score score);
}
