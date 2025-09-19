package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Weight;

public interface WeightRepository extends JpaRepository<Weight, Long> {
}
