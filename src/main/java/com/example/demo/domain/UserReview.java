package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*@Entity
@Getter
@Table(name = "userreview")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReview {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;
    private String usercode;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "userreview")
    private List<UserReReview> userReReview = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private CommunityReview communityReview;

    private LocalDateTime localDateTime; // 리뷰 작성 시간

    private int good;
    private int bad;




}*/
