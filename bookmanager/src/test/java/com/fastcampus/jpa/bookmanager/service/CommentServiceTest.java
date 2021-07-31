package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void  commentTest(){
        commentService.init();
 //       commentRepository.findAll().forEach(System.out::println);

        commentService.updateSomething();
        commentService.insertSomething(); //영속화가 되기전이기때문에 dirty-checking이 일어나지 않는다..


    }
}
