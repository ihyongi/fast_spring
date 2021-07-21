package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber; //phone_number
    @JsonProperty("OTP")
    private String OTP;
    //왜 null값이 뜰까? 카멜이랑 스네이크방식 달라서 매핑해줘야함


    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
