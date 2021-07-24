package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
       return "hello";
    }

    //@ApiParam(value = "x값")
    @ApiImplicitParams({
                    @ApiImplicitParam(name ="x", value = "x값", required = true, dataType = "int"),
                    @ApiImplicitParam(name ="y", value = "y값", required = true, dataType = "int")
            })
    @GetMapping("/plus/{x}")
    public int plus( @PathVariable int x, @RequestParam int y){
        return x+y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 echo하는 메소드") //설명이 붙는다
    @GetMapping("/user")
    public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());

    }

    @PostMapping("/user")
    public UserRes userPost(UserReq req){
        return new UserRes(req.getName(), req.getAge());

    }
}
