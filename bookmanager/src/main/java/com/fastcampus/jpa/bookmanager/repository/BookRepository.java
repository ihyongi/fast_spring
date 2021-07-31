package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    //210731
    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

    @Query(value = "select b from Book b "
            + "where b.name = :name and b.createdAt >= :createdAt and b.updatedAt >= :updatedAt and b.category is null") //jpql
    //순서의존 지양.. ?1,?2 이거보단 name기반의 파라미터 ..:name, :createdAt이런식으로..매핑 파라미터 순서에 영향을 받지않게됨
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt);

    //full패키지이름 쓸것 ..한번에 바꾸기!
    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    //오버로딩
    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    @Transactional
    @Modifying //업데이트라고 표시해줌
    @Query(value = "update book set category = 'IT전문서'", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();

    @Query(value = "select * from book order by id desc limit 1", nativeQuery = true)
    Map<String, Object> findRawRecord();

}
