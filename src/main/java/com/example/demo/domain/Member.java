package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")

    private Long id;
    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<MainContents> mainContents = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userreview_id")
    private UserReview userReview;

    public Member(String username, UserReview userReview) {
        this.username = username;
        if (userReview != null) {
            changeuserReview(userReview);
        }
    }

    public void changeuserReview(UserReview userReview) {
        this.userReview = userReview;
        userReview.getMembers().add(this);
    }
}
