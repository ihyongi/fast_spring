package com.example.filter.controller;

import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그
@RestController
@RequestMapping("/api/temp")
public class ApiUserController {

    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("Temp:{}",user); //이렇게 쓰주아~!
        return user;
    }

    @DeleteMapping("/delete")
    public ResponseEntity post(){
        return ResponseEntity.ok().build();
    }
}
