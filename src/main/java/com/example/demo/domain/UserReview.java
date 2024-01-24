package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "usercode"})
public class UserReview {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;
    private String usercode;

    @OneToMany(mappedBy = "userReview")
    private List<Member> members = new ArrayList<>();

    public UserReview(String usercode) {
        this.usercode = usercode;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "re_review_id")
    private List<UserReReview> userReReviews = new ArrayList<>();

}
