package com.idiot.exam.controller;

import com.idiot.exam.common.Result;
import com.idiot.exam.service.ExamPaperService;
import com.idiot.exam.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PaperController {

    @Autowired
    private ExamPaperService examPaperService;

    @GetMapping("/Paper/findAllPaper")
    @ResponseBody
    public Result findAll() {

        return ApiResult.succ(200,"请求成功",examPaperService.findAll());
    }



}
