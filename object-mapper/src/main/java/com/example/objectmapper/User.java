package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class User {

    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
