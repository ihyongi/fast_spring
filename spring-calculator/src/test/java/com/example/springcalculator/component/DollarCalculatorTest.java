package com.example.springcalculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MarketApi.class, DollarCalculator.class}) //주입
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;

    @Test
    public void dollarCalculatorTest(){
        //calculator.init(); //꼭!!!! 안그럼 3000원적용이안돼
        Mockito.when(marketApi.connect()).thenReturn(3000);

        int sum=calculator.sum(10,10);
        int minus=calculator.minus(10,10);
        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);

        System.out.println("minus = " + minus);
        System.out.println("sum = " + sum);

    }
}
