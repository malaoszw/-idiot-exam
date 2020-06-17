package com.idiot.exam.dao;

import com.idiot.exam.domain.SingleChoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SingleChoiceDao {

    @Select("select questionId,subject,question,answerA,answerB,answerC,answerD,score from question where questionId in (select questionId from exam_paper where questionType = 1 and paperId = #{paperId})")
    List<SingleChoice> findByIdAndType(Integer PaperId);

    @Select("select * from question")
    List<SingleChoice> findAll();

    @Select("select questionId from question order by questionId desc limit 1")
    SingleChoice findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into question(subject,question,answerA,answerB,answerC,answerD,rightAnswer,score) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{score})")
    int add(SingleChoice singleChoice);

    @Select("select questionId from question  where subject =#{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject,Integer pageNo);
}
