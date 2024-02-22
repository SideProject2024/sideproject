package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/*@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")

    private Long id;
    private String userEmail;
    private String userName;
    private String userBirth;
    private String userNick;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    @JoinColumn(name = "userreview_id")
    private List<UserReview> userReview = new ArrayList<>();


}*/
