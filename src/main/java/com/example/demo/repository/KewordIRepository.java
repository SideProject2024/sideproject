package com.example.demo.repository;

import com.example.demo.entity.KewordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface KewordIRepository extends JpaRepository<KewordEntity,Long> {
    List<KewordEntity> findByMovieid(String movie_id);

    @Query("SELECT NEW map(COUNT(word) as count,movieid as movieid) FROM KewordEntity GROUP BY movieid")
    List<Map<String, Object>> countByMovieId();
}
