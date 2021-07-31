package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Address;
import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Autowired
    private EntityManager em;


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
        void select() {
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
            System.out.println("findUserByEmail : " + userRepository.findByEmailAndName("dubu@naver.com", "dubu"));
            System.out.println("findUserByEmail : " + userRepository.findByEmailOrName("dubu@naver.com", "dubu"));
            System.out.println("userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)) = " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByIdAfter() = " + userRepository.findByIdAfter(4L));
            System.out.println("userRepository.findByCreatedAtGreaterThan() = " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByCreatedAtGreaterThanEqual() = " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
            System.out.println("userRepository.findByCreatedAtBetween() = " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
            System.out.println("userRepository.findByIdBetween() = " + userRepository.findByIdBetween(1L, 3L));
            System.out.println("userRepository.findByIdGreaterThanEqualAndIdLessThanEqual() = " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

            System.out.println("userRepository.findByIdIsNotNull() = " + userRepository.findByIdIsNotNull());
            //System.out.println("userRepository.findByAddressIsNotEmpty() = " + userRepository.findByAddressIsNotEmpty()); //[]
            System.out.println("userRepository.findByNameIn() = " + userRepository.findByNameIn(Lists.newArrayList("pinggu", "dubu")));
            System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("pin"));
            System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("gu"));
            System.out.println("findByNameContains : " + userRepository.findByNameContains("bu"));
            System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "ping" + "%"));
        }
            @Test
            void pagingAndSortingTest(){
            System.out.println("findTop1ByName : " + userRepository.findTop1ByName("angmu"));
            System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("angmu"));
            System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("pinngu"));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinngu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
            System.out.println("findByNameWithPaging : " + userRepository.findByName("dubu", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
         }

            @Test
            void insertAndUpdateTest() {
                User user = new User();
                user.setName("bella");
                user.setEmail("bella@fastcampus.com");
                userRepository.save(user);

                User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
                user2.setName("parkjekyll"); //mang
                userRepository.save(user2);//update
            }

            @Test
            void enumTest() {
                User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
                user.setGender(Gender.MALE);
                userRepository.save(user);

                userRepository.findAll().forEach(System.out::println);
                System.out.println(userRepository.findRawRecord().get("gender"));
            }

            @Test
            void listenerTest() {
                User user = new User();
                user.setEmail("martin2@fastcampus.com");
                user.setName("martin");
                userRepository.save(user);

                User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
                user2.setName("marrrrrtin");
                userRepository.save(user2);
                userRepository.deleteById(4L);
            }

            @Test
            void prePersistTest() {
                User user = new User();
                user.setEmail("bella@fastcampus.com");
                user.setName("bella");
                user.setCreatedAt(LocalDateTime.now());
                user.setUpdatedAt(LocalDateTime.now());

                userRepository.save(user);
                System.out.println(userRepository.findByEmail("bella@fastcampus.com"));
            }

            @Test
            void preUpdateTest() {
                User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
                System.out.println("as-is : " + user);

                user.setName("martin22");
                userRepository.save(user);
                System.out.println("to-be : " + userRepository.findAll().get(0));
            }

            @Test
            void userHistoryTest() {
                User user = new User();
                user.setEmail("martin-new@fastcampus.com");
                user.setName("martin-new");
                userRepository.save(user);

                user.setName("martin-new-new");
                userRepository.save(user);
                userHistoryRepository.findAll().forEach(System.out::println); //얘가 null값이뜬다
            }

            @Test
            void userRelationTest(){
                User user = new User();
                user.setName("ping");
                user.setEmail("ping@gmail.com");
                user.setGender(Gender.FEMALE);

                user.setName("bella");
                userRepository.save(user);
                user.setEmail("bella@fastcampus.com");
                userRepository.save(user);

                userHistoryRepository.findAll().forEach(System.out::println);

//                List<UserHistory> result = userHistoryRepository
//                                .findByUserId(userRepository.findByEmail("bella@fastcampus.com")
//                                .getId());

                List<UserHistory> result = userRepository.findByEmail("bella@fastcampus.com").getUserHistories();
                result.forEach(System.out::println);

                System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());

            }
    @Test
    void embedTest() {
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("jekyll");
        user.setHomeAddress(new Address("서울시", "강남구", "강남대로 364 미왕빌딩", "06241"));
        user.setCompanyAddress(new Address("서울시", "성동구", "성수이로 113 제강빌딩", "04794"));

        userRepository.save(user);

        User user1 = new User();
        user1.setName("hellen");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("carolina");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());

        userRepository.save(user2);

//        em.clear(); //영속성컨텍스트의 캐시를 한번 밀고..

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        userRepository.findAllRawRecord().forEach(a -> System.out.println(a.values())); //찾으면 디비에서 조회

        assertAll(
                ()->assertThat(userRepository.findById(6L).get().getHomeAddress()).isNotNull(),
                ()->assertThat(userRepository.findById(7L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }


}