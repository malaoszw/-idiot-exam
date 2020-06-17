package com.idiot.exam.controller;

import com.idiot.exam.common.Result;
import com.idiot.exam.service.ExamManageService;
import com.idiot.exam.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ExamManageController {

    @Autowired
    ExamManageService examService;

    @GetMapping ("/Exam/findAllExam")
    @ResponseBody
    public Result finAllExam(){
        return ApiResult.succ(200, "请求成功", examService.findAll());
    }
}
