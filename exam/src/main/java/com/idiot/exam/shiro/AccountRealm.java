package com.idiot.exam.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.idiot.exam.domain.Student;
import com.idiot.exam.service.LoginService;
import com.idiot.exam.service.StudentService;
import com.idiot.exam.util.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    StudentService studentService;
    @Autowired
    LoginService loginService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        //log.info("jwt----------------->{}", jwt);
        String studentId = jwtUtil.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        //User user = userService.getById(Long.parseLong(userId));
        Student student =loginService.studentLogin(studentId);

        if(student == null) {
            throw new UnknownAccountException("账户不存在！");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(student, profile);
        //log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());

    }
}
