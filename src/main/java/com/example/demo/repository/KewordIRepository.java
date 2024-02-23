package com.example.demo.repository;

import com.example.demo.entity.kewordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KewordIRepository extends JpaRepository<kewordEntity,Long> {

}
