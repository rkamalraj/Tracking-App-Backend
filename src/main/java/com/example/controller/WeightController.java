package com.example.controller;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Weight;
import com.example.repository.WeightRepository;

import java.util.List;

@RestController
@RequestMapping("/api/weights")
@CrossOrigin(origins = "*") // Allow frontend access
public class WeightController {

    private final WeightRepository repo;

    public WeightController(WeightRepository repo) {
        this.repo = repo;
    }

    // Add weight
    @PostMapping
    public Weight addWeight(@RequestBody Weight weight) {
        return repo.save(weight);
    }

    // Get all weights
    @GetMapping
    public List<Weight> getAllWeights() {
        return repo.findAll();
    }
}
