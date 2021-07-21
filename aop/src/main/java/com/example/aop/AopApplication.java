package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
        System.out.println(Base64.getEncoder().encodeToString("025031210@naver.com".getBytes(StandardCharsets.UTF_8)));
        //MDI1MDMxMjEwQG5hdmVyLmNvbQ==
        //포스트맨에서 put

    }


}
