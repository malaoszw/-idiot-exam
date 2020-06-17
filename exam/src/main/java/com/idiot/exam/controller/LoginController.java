package com.idiot.exam.controller;

import com.idiot.exam.domain.Login;
import com.idiot.exam.common.Result;
import com.idiot.exam.domain.Student;
import com.idiot.exam.service.LoginService;
import com.idiot.exam.util.ApiResult;
import com.idiot.exam.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {



    /*   @Autowired
       StudentService studentService;
       @RequestMapping("/")
       @ResponseBody
       public Result sayHello(){
           return ApiResult.succ(200,"操作成功",studentService.findAll());
       }*/
    @Autowired
    LoginService loginService;

    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/student/login")
    @ResponseBody
    public Result studentLogin(@Validated @RequestBody Login login, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        String username=login.getUsername();
        String password=login.getPassword();
        Student student = loginService.studentLogin(username);
        //System.out.print("用户"+student);
       if(student!=null){

           if (student.getPassword().equals(login.getPassword())) {

               String jwt = jwtUtil.generateToken(student.getId().toString());
               //System.out.print("jwt"+jwt);
               response.setHeader("Authorization", jwt);
               response.setHeader("Access-control-Expose-Headers", "Authorization");
               map.put("studentId",student.getId());
               return ApiResult.succ(200, "请求成功", map);
           }
           return ApiResult.fail(400,"密码错误",null);
       }
       else{
           return ApiResult.fail(400,"用户不存在",null);

       }
        /*map.put("studentId",student.getId());
        if (!student.getPassword().equals(login.getPassword())) {

            return ApiResult.fail(400,"密码错误",null);
            // return ApiResult.succ();
        }*/
    }
    @RequiresAuthentication
    @GetMapping("/student/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return ApiResult.succ(200,"退出成功",null);
    }

}
