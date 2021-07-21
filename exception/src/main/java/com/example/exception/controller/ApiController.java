package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min = 2)
            @RequestParam String name,
            @NotNull
            @RequestParam Integer age){ //필수가 아니다
        User user=new User();
        user.setName(name);
        user.setAge(age);

        int a=10+age;//예외발생시키기

       return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println("user = " + user);

        return user;
    }


//    //여기가 훨씬 우선순위
//   @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
//        System.out.println("api controller");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); //바디에 메시지 담아서 가져와
//    }
}
