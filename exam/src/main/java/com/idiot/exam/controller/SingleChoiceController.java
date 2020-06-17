package com.idiot.exam.controller;

import com.idiot.exam.domain.SingleChoice;
import com.idiot.exam.service.SingleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SingleChoiceController {
    @Autowired
    private SingleChoiceService singleChoiceService;

    @GetMapping("/Questions/{paperId}")
    @ResponseBody
    public Map<String, List<?>> findByIdAndType(@PathVariable("paperId") Integer paperId) {
        List<SingleChoice> singleChoiceQuestionRes = singleChoiceService.findByIdAndType(paperId);   //选择题题库 1
        Map<String, List<?>> map = new HashMap<>();
        map.put("singleChoice",singleChoiceQuestionRes);//暂时实现第一部分选择题，第二部分填空题后续在更新
        //map.put(2,singleChoiceQuestionRes);
        return  map;
        // return null;
    }
}
