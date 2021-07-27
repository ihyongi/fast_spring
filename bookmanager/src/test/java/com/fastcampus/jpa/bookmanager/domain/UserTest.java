package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("02503120@naver.com");
        user.setName("ihyongi");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        //User user1 = new User(null,"martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now(), null);
        User user2 = new User("martin", "martin@fastcampus.com");
        User user3 = User.builder()
                .name("martin")
                .email("martin@fastcampus.com")
                .build();

        System.out.println("user = " + user.toString()); //이렇게 찍으면 해시코드 주소값이 나옴 ->이래서 toString하는거!
    }
}