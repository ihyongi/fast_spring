package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    //get은 requestParam
    //post는 requestBody

//    @PostMapping("/post")
//    public void post(@RequestBody Map<String,Object> requsetData){
//        requsetData.forEach((key, value) -> {
//            System.out.println("key = " + key);
//            System.out.println("value = " + value);
//        });
//    }

    //어노테이션 여기선 빼면안되네 ㅜㅜ
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestDto){
        System.out.println("requestDto = " + requestDto);
    }
}
