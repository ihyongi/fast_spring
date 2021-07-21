package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping("/hello") //localhost:9090/api/get/hello
    public String getHello(){
        return "get hello";
    }

    //예전 방식
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    //http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("PathVariable"+pathName);
        return pathName;
    }



    //쿼리파라미터 -매개인자.! ?키=밸류
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb=new StringBuilder();

        queryParam.entrySet().forEach( entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+"="+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    //추천--객체미리 정의하고 선언할 것
    //좀더 명시적
    @GetMapping(path = "query-param02")
    public String queryParam02( @RequestParam String name, @RequestParam String email, @RequestParam int age){
        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("age = " + age);

        return name+" "+email+" "+age;
    }

    //객체인경우 판단하여 따로 @RequestParam붙이지 않아도 인식
    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println("name = " + userRequest.getName());
        System.out.println("email = " + userRequest.getEmail());
        System.out.println("age = " + userRequest.getAge());

        return userRequest.toString();
    }

}
