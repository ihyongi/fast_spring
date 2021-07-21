package com.example.aop.dto;

import lombok.Data;

@Data
public class User {

    private String id;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
