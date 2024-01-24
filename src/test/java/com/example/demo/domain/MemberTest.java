package com.example.demo.domain;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;

    public void testEntity() {
        UserReview userReview1 = new UserReview("userreview1");
        UserReview userReview2 = new UserReview("userreview2");
        em.persist(userReview1);
        em.persist(userReview2);

        Member member1 = new Member("member1", userReview1);
        Member member2 = new Member("member2", userReview2);

        em.persist(member1);
        em.persist(member2);

        // 초기화

        em.flush();
        em.clear();

        em.createQuery("select m from Member m", Member.class)
                .getResultList();


    }

}