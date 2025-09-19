package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Weight;
import com.example.repository.WeightRepository;

@Service
public class WeightService {

    private final WeightRepository repo;

    public WeightService(WeightRepository repo) {
        this.repo = repo;
    }

 // Add or Update weight (one entry per user per day)
    public Weight addOrUpdateWeight(Weight weight) {
        LocalDate today = LocalDate.now();

        // Check if user already has weight for today
        Optional<Weight> existing = repo.findByUserIdAndRecordedAtBetween(
                weight.getUserId(),
                today.atStartOfDay(),
                today.plusDays(1).atStartOfDay()
        );

        if (existing.isPresent()) {
            Weight w = existing.get();
            w.setWeight(weight.getWeight()); // update only weight value
            return repo.save(w);
        } else {
            return repo.save(weight); // create new record
        }
    }

    
    public List<Weight> getAllWeights() {
        return repo.findAll();
    }
}
