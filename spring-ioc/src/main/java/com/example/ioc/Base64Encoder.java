package com.example.ioc;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component //빈으로 등록해라 --스프링이 관리하도록
public class Base64Encoder implements IEncoder {

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes(StandardCharsets.UTF_8));
    }
}
