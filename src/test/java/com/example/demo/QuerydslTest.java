package com.example.demo;

import com.example.demo.entity.HelloTest;
import com.example.demo.entity.QHelloTest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class QuerydslTest {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        HelloTest helloTest = new HelloTest();
        em.persist(helloTest);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHelloTest qHelloTest = new QHelloTest("h");

        HelloTest result = query
                .selectFrom(qHelloTest)
                .fetchOne();

        assertThat(result).isEqualTo(helloTest);
    }
}
