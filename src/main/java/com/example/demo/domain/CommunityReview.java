package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class CommunityReview {

    @Id
    @GeneratedValue
    @Column(name = "CommunityReview_id")
    private Long id;
}
