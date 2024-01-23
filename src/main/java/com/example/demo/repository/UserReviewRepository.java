package com.example.demo.repository;

import com.example.demo.domain.UserReview;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserReviewRepository {
    private final EntityManager em;

    public void save(UserReview userReview) {
        em.persist(userReview);
    }

    public UserReview findOne(Long id) {
        return em.find(UserReview.class, id);
    }


}
