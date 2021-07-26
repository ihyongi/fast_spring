package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든생성자
@RequiredArgsConstructor //final
@Data //getter, setter
@Builder
@Entity //반드시 pk가 필요하다
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull //필수값
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;


}
