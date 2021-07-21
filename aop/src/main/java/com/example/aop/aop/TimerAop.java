package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component //빈은 클래스에 붙일 수 없으나 컴포넌트는 클래스 단위로 빈에 등록
public class TimerAop {

    //어떤 것을 AOP로 볼것인가? 설정
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){

    }

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();//이것을 중심으로 위아래에서 시간을 잼

        stopWatch.stop();
        System.out.println("total time = " + stopWatch.getTotalTimeSeconds()); //총걸린시간
    }
    //실질적인 로직이 들어갈 곳에 부가적인것이 반복적으로 들어가기때문에 따로 뺀거

}
