package com.sp.fc.web;

import com.sp.fc.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicTestApplication {
    // 공용 프로젝트 : comp-common-utils
    // 서버 프로젝트 : server-basiec-test
    // 분리된 server-basiec-test -> build.gradle 에서 compile project(":comp-common-utils") 선언
    public static void main(String[] args) {
        SpringApplication.run(BasicTestApplication.class, args);

        Person person = Person.builder().name("test").build();
        System.out.println(person);

    }

}
