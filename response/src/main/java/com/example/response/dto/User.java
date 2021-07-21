package com.example.response.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
//@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
//널값 포함시키지않고?
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String name;
    private Integer age; //null허용
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
