package com.idiot.exam.controller;

import com.idiot.exam.common.Result;
import com.idiot.exam.domain.Score;
import com.idiot.exam.service.ScoreService;
import com.idiot.exam.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @GetMapping("Score/{studentId}")
    @ResponseBody
    public Result findStudentScoreAll(@PathVariable("studentId")Integer studentId){
       List<Score>scores= scoreService.findStudentScoreAll(studentId);
       if(scores!=null)
       {
           return ApiResult.succ(200,"请求成功",scores);
       }
        return ApiResult.fail(400,"查询失败",null);

    }
}
