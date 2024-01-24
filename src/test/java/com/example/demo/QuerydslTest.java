package com.example.demo;

import com.example.demo.entity.HelloTest;
import com.example.demo.entity.QHelloTest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
public class QuerydslTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
        HelloTest helloTest = new HelloTest();
        em.persist(helloTest);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHelloTest qHelloTest = QHelloTest.helloTest;

        HelloTest result = query
                .selectFrom(qHelloTest)
                .fetchOne();

        assertThat(result).isEqualTo(helloTest);
        assertThat(result.getId()).isEqualTo(helloTest.getId());
    }
}
