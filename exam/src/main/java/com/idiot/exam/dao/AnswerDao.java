package com.idiot.exam.dao;


import com.idiot.exam.domain.Answer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnswerDao {
    @Options(useGeneratedKeys = true,keyProperty = "answerId")
    @Insert("insert into answer(examCode,questionId,userAnswer,studentId) " +
            "values(#{examCode},#{questionId},#{userAnswer},#{studentId})")
    int add(Answer answer);

    @Select("select * from answer where userId=#{studentId} and examCode=#{examCode}")
    List<Answer> findByUserIdAndExamCode(Integer studentId,Integer examCode);

    @Select("select * from answer")
    List<Answer> findAll();
    @Select("select answer from answer where studentId=#{studentId} and examCode=#{examCode}")
    Answer findUserAnswerByUserIdAndExamCode(Integer studentId,Integer examCode);

    @Select("select count(*) from answer where studentId=#{studentId} and examCode=#{examCode}")
    int findCountByUserIdAndExamCode(Integer studentId,Integer examCode);

    @Update("update answer set score = #{score}" +
            " where answerId=#{answerId}")
    int updateScore(Integer score,Integer answerId);

    @Select("SELECT * from answer,question where answer.questionId=question.questionId and answer.userAnswer=question.rightAnswer")
    List<Answer> findAnswerId();

    @Select("select sum(score) from  answer where studentId=#{studentId} and examCode=#{examCode}")
    int findTotalScoreByUserIdAndExamCode(Integer studentId,Integer examCode);

}
