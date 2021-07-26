package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional //getOne은 lazy를 지원하고잇다
    void crud(){
        //페이징처리
//        Page<User> users=userRepository.findAll(PageRequest.of(0,3));
//        System.out.println("users = " + users);
//
//        System.out.println("users.getTotalElements() = " + users.getTotalElements());
//        System.out.println("users.getTotalPages() = " + users.getTotalPages());
//        System.out.println("users.getNumberOfElements() = " + users.getNumberOfElements());
//        System.out.println("users.getSort() = " + users.getSort());
//        System.out.println("users.getSize() = " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        //query by excute
//        ExampleMatcher matcher=ExampleMatcher.matching()
//                //.withIgnorePaths("name")
//                .withMatcher("email",endsWith());
//
//        Example<User> example=Example.of(new User("pinggu","naver.com"), matcher);
//        userRepository.findAll(example).forEach(System.out::println);

        //update
        userRepository.save(new User("bella","025031210@naver.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("ihyongi@github.com");
        userRepository.save(user);

        System.out.println("user = " + user);
    }

        //조회쿼리들 간단하게 만들기 .. queryMethod
        @Test
        void select(){
//            System.out.println("userRepository.findByName(\"\") = " + userRepository.findByName("pinggu"));
//            System.out.println("userRepository.findByEmail(\"025031210@naver.com\") = " + userRepository.findByEmail("025031210@naver.com"));
//            System.out.println("userRepository.getByEmail(\"025031210@naver.com\") = " + userRepository.getByEmail("025031210@naver.com"));
//            System.out.println("userRepository.readByEmail(\"025031210@naver.com\") = " + userRepository.readByEmail("025031210@naver.com"));
//            System.out.println("userRepository.queryByEmail(\"025031210@naver.com\") = " + userRepository.queryByEmail("025031210@naver.com"));
//            System.out.println("userRepository.searchByEmail(\"025031210@naver.com\") = " + userRepository.searchByEmail("025031210@naver.com"));
//            System.out.println("userRepository.streamByEmail(\"025031210@naver.com\") = " + userRepository.streamByEmail("025031210@naver.com"));
//            System.out.println("userRepository.findUserByEmail(\"025031210@naver.com\") = " + userRepository.findUserByEmail("025031210@naver.com"));
//            System.out.println("userRepository.findSomethingByEmail(\"025031210@naver.com\") = " + userRepository.findSomethingByEmail("025031210@naver.com"));
//
//            System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("pinggu"));
//            System.out.println("findTop1ByName : " + userRepository.findTop1ByName("pinggu"));
//            System.out.println("findLast1ByName : " + userRepository.findLast1ByName("pinggu"));
            System.out.println("findUserByEmail : " + userRepository.findByEmailAndName("dubu@naver.com","dubu"));
            System.out.println("findUserByEmail : " + userRepository.findByEmailOrName("dubu@naver.com","dubu"));
            System.out.println("userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)) = " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByIdAfter() = " + userRepository.findByIdAfter(4L));
            System.out.println("userRepository.findByCreatedAtGreaterThan() = " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByCreatedAtGreaterThanEqual() = " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByCreatedAtBetween() = " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
            System.out.println("userRepository.findByIdBetween() = " + userRepository.findByIdBetween(1L, 3L));
            System.out.println("userRepository.findByIdGreaterThanEqualAndIdLessThanEqual() = " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

            System.out.println("userRepository.findByIdIsNotNull() = " + userRepository.findByIdIsNotNull());
            System.out.println("userRepository.findByAddressIsNotEmpty() = " + userRepository.findByAddressIsNotEmpty()); //[]
            System.out.println("userRepository.findByNameIn() = " + userRepository.findByNameIn(Lists.newArrayList("pinggu","dubu")));
            System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("pin"));
            System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("gu"));
            System.out.println("findByNameContains : " + userRepository.findByNameContains("bu"));

            System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "ping" + "%"));
            System.out.println("findTop1ByName : " + userRepository.findTop1ByName("angmu"));
            System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("angmu"));
            System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("pinngu"));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findByNameWithPaging : " + userRepository.findByName("dubu", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());

    }



}