package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당클래스는 restapi를 처리하는 controller
@RequestMapping("/api") //url을 지정해주는 어노테이션
public class ApiController {

    @GetMapping("/hello") //localhost:9090/api/hello
    public String hello(){
        return "hello Spring boot!";
    }
}
