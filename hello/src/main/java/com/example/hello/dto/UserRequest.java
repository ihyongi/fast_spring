package com.example.hello.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private int age;

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
