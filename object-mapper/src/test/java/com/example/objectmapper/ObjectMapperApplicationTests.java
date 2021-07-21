package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-------------------------");

        //text json-> object
        //object ->text json

        var objectMapper =new ObjectMapper();
        //object->text
        //objectMapper가 get메서드를 사용한다
        //objectMapper가 참조하는 클래스에는 메서드명에 get붙이지 말라!!!!!!!!!!!!!
        var user=new User("ihyongi",29,"010-4481-8888");
        var text= objectMapper.writeValueAsString(user);
        System.out.println("text = " + text);

        //text->object
        //여기서는 디폴트 생성자가 필요함!!!
        var objectUser =objectMapper.readValue(text,User.class);
        System.out.println("objectUser = " + objectUser);
    }

}
