package com.fastcampus.jpa.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Embeddable //embed를 할 수 있는 클래스임을 명시
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
//    @Id
//    private Long id;

    private String city;    // 시
    private String district;    // 구

    @Column(name = "address_detail")
    private String detail;  // 상세주소
    private String zipCode; // 우편번호
}
