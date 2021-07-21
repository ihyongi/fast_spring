package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    //어떤 것을 AOP로 볼것인가? 설정
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode(){

    }

    //전
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object [] args=joinPoint.getArgs(); //매개변수들의 배열
        for (Object obj : args) {
            if(obj instanceof User){
                User user=User.class.cast(obj);
                String base64Email=user.getEmail(); //여기서는 decoding
                String email=new String(Base64.getDecoder().decode(base64Email),"UTF-8"); // 형변환
                user.setEmail(email);
            }
        }
    }


    //후
    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) throws UnsupportedEncodingException {
        if(returnObj instanceof User){
            User user=User.class.cast(returnObj);
            String email=user.getEmail(); //이번에는 encoding
            String base64Email=Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8)); // 형변환
            user.setEmail(base64Email);
        }

    }
}
