package com.idiot.exam.controller;

import com.idiot.exam.common.Result;
import com.idiot.exam.domain.SingleChoice;
import com.idiot.exam.domain.Student;
import com.idiot.exam.service.SingleChoiceService;
import com.idiot.exam.service.StudentService;
import com.idiot.exam.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StundentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/Student/{studentId}")
    @ResponseBody
    public Result findById(@PathVariable("studentId") Integer studentId) {
        Map<String,Object> map = new HashMap<>();
        Student student=studentService.findById(studentId);
        if(student!=null)
        {
            student.setId(studentId);
            return ApiResult.succ(200,"请求成功",student);
        }
        return ApiResult.fail(400,"查询失败",null);

        // return null;
    }
}
