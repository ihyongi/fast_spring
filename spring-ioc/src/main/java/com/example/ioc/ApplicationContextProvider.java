package com.example.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context; //1.

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext ;//2.할당해주기
    }

    //3. 가져다 쓰기위한 준비완료..?
    public static ApplicationContext getContext(){
        return context;
    }
}
