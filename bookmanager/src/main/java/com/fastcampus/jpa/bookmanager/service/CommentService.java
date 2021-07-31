package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Comment;
import com.fastcampus.jpa.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("최고예요");

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly=true) //org.springframework.transaction.annotation.Transactional
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for (Comment comment : comments) {
            comment.setComment("별로예요");

//            commentRepository.save(comment); //여기서도 update가 일어난다.. 더티체킹..별도의 save없이도 update가 일어남.영속성에 의해서
            //운영서버에서는 trace no....
            //매번 더티체킹.. 수만건의 경우 성능에도 영향이 가는데 .. 이러면? readOnly=true로

        }
    }

    @Transactional
    public void insertSomething() {
//        Comment comment = new Comment();
        Comment comment = commentRepository.findById(1L).get();
        comment.setComment("이건뭐죠?");

        //이경우에는 별도로 save작업이 필요
        commentRepository.save(comment);
    }
}
