package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReReview {
    @Id
    @GeneratedValue
    @Column(name = "user_rereview_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userreview_id")
    private UserReReview userReReview;
    private int good;
    private int bad;
}
