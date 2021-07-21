package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Auth
@RestController
@RequestMapping("/api/private")
@Slf4j
public class PrivateController {

    //세션이인증된 사용자
    @GetMapping("/hello")
    public String hello(){
        log.info("private hello controller");
        return "private hello";
    }
}
