package com.idiot.exam.controller;

import com.idiot.exam.common.Result;
import com.idiot.exam.domain.Answer;
import com.idiot.exam.domain.Score;
import com.idiot.exam.service.AnswerService;
import com.idiot.exam.service.ScoreService;
import com.idiot.exam.timerTask.MyScheduler;
import com.idiot.exam.util.ApiResult;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
public class AnswerController {

    @Autowired
    AnswerService answerService;
    @Autowired
    ScoreService scoreService;

    @RequestMapping(value="/Answer/add",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public Result findScore(@Validated @RequestBody Answer[] json, HttpServletResponse response){
        // Answer answer=json;;
        //return ApiResult.fail("请求失败");
        //Answer answer=json;
        if(answerService.findCountByUserIdAndExamCode(json[0].getStudentId(),json[0].getExamCode())<10)
        {
            for(Answer ans:json)
            {
                //System.out.print(ans.getAnswer());
                answerService.add(ans);
            }
            scoreService.add(json[0].getExamCode(),json[0].getStudentId());
            //System.out.print(answerService.findCountByUserIdAndExamCode(json[0].getUserId(),json[0].getExamCode()));
            //System.out.print("可以插入"+json[0].getUserId()+"xx:"+json[0].getExamCode());
            return ApiResult.succ(200,"请求成功",json);
        }else{
            System.out.print("无法插入");
            return ApiResult.fail(400,"请求失败",null);
        }

        //System.out.print(json);
        /*HashMap map=new HashMap<String,String>();
        for(String st: str)
        {
            String string []=st.split(",");
            map.put(string[0],str[1]);
        }*/

    }
    @GetMapping("/Answer/judge")
    @ResponseBody
    public void findAll() {

        MyScheduler myScheduler=new MyScheduler();
        try {
             myScheduler.test();
             List<Answer> answers=answerService.findAnswerId();
             List<Score> scores=scoreService.findAll();

            for(Answer ans:answers)
            {
               ans.setScore(10);
               answerService.updateScore(ans.getScore(),ans.getAnswerId());
             }
            for(Score score:scores)
            {
                scoreService.update(score);
            }

        } catch (SchedulerException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
