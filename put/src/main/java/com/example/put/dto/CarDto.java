package com.example.put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class) //스네이크 방식으로 하겠다
public class CarDto {

    private String name;
    @JsonProperty("car_number") //특정변수만 이렇게 하겠다
    private String carNumber;

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
