package com.example.repository;

import com.example.entity.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WeightRepository extends JpaRepository<Weight, Long> {

    @Query("SELECT w FROM Weight w WHERE w.userId = :userId AND w.recordedAt >= :start AND w.recordedAt < :end")
    Optional<Weight> findByUserIdAndRecordedAtBetween(Long userId, LocalDateTime start, LocalDateTime end);
}
