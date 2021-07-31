package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.converter.BookStatusConverter;
import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.repository.dto.BookStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@DynamicUpdate
@Where(clause = "deleted=false")
public class Book extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    // private Long publisherId;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude //stackoverflow방지
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) //상위객체가 remove->하위의 (영속적인)포함되고 있는 객체까지 remove
    @ToString.Exclude
    private Publisher publisher;

    // @ManyToMany
    @OneToMany
    @JoinColumn(name="book_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    private boolean deleted; //진짜 삭제하기보다는 컬럼을 하나 넣어서 확인만 하는구나..

    //@Convert(converter = BookStatusConverter.class) //어떤 컨버터를 적용시킬지
    private BookStatus status; // 판매상태 --오류마크가뜨지만 문제가없다 .. @Converter(autoApply = true)처리해서

    public void addBookAndAuthor(BookAndAuthor... bookAndAuthors){
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }


}