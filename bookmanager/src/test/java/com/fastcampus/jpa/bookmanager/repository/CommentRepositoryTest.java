package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void commentTest() {
        Comment comment = new Comment();
//        Comment comment=commentRepository.findById(3L).get();
//        comment.setComment("별로예요");
        comment.setCommentedAt(LocalDateTime.now());

        commentRepository.saveAndFlush(comment);

//        em.clear();
//
//        System.out.println(commentRepository.findById(3L).get());

        System.out.println(comment);

        commentRepository.findAll().forEach(System.out::println);
    }

}