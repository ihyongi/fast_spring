package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //aop로 동작하기 위해붙이는 어노테이션
@Component //스프링에서 관리해줘
public class ParameterAop {

    //어떤 것을 AOP로 볼것인가? 설정 어렵다..
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }

    @Before("cut()") //cut()이 실행되는 지점에 실행된다
    public void before(JoinPoint joinPoint){

        //2.메소드 이름 출력
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        System.out.println("method.getName() = " + method.getName());


        //1.
        Object [] args=joinPoint.getArgs(); //매개변수들의 배열 --메소드이름은 조인포인트에서 가져올 수 있다
        for (Object obj : args) {
            System.out.println("type = " + obj.getClass().getSimpleName()); //메소드 타입 :User
            System.out.println("value = " + obj); //메소드 이름
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") //반환도 어느시점에서 할 것인가?, 내가받고싶은 객체
    public void afterReturning(JoinPoint joinPoint, Object returnObj){
        System.out.println("returnObj = " + returnObj);
    }
}
