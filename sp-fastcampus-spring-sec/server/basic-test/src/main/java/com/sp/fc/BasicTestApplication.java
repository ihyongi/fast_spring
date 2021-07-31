package com.sp.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicTestApplication {

    //person을 쓰려면?
    Person person=null;

    public static void main(String[] args) {
        SpringApplication.run(BasicTestApplication.class, args);
    }
}
