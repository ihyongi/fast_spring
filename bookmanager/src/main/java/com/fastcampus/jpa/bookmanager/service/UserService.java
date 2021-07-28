package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {
    @Autowired
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("Bella");
        user.setEmail("Bella@fastcampus.com");

        //userRepository.save(user);
        em.persist(user);
        em.detach(user); //준영속상태

        user.setName("newUserAfterPersist");
        //em.merge(user);
        //em.clear();

        User user1 = userRepository.findById(1L).get();
        em.remove(user1);

        user1.setName("Belllllllllla");
        //em.merge(user1);

    }
}
