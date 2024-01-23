package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MainContents {

    private final EntityManager em;

    public MainContents findOne(Long id) {
        return em.find(MainContents.class, id);
    }

    public List<MainContents> findAll() {
        return em.createQuery("select mc from MainContents mc", MainContents.class)
                .getResultList();
    }
}
