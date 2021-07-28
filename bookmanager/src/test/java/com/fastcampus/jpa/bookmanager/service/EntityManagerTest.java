package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest() {
//        System.out.println(userRepository.findByEmail("mang@naver.com"));
//        System.out.println(userRepository.findByEmail("mang@naver.com"));
//        System.out.println(userRepository.findByEmail("mang@naver.com"));
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(4L).get());

        userRepository.deleteById(1L);
        //1차캐시.. entity map형식으로 존재
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("bellllllllllllla");
        userRepository.save(user);

        System.out.println("---------------------");

        user.setEmail("bellllllllllllla@fastcampus.com");
        userRepository.save(user);
        //userRepository.flush();

//        System.out.println("userRepository1 = " +userRepository.findById(1L).get());       // select * from user
//        userRepository.flush();
        System.out.println("userRepository2 = " + userRepository.findAll());
    }

}
