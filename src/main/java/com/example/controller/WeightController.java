package com.example.controller;

import com.example.entity.Weight;
import com.example.service.WeightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weights")
@CrossOrigin(origins = "*") // Allow frontend access
public class WeightController {

    private final WeightService service;

    public WeightController(WeightService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Weight addOrUpdateWeight(@RequestBody Weight weight) {
        return service.addOrUpdateWeight(weight);
    }
    
    // ✅ Unique endpoint to get all weights
    @GetMapping("/all")
    public List<Weight> getAllWeights() {
        return service.getAllWeights();
    }
}



//package com.example.controller;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.entity.Weight;
//import com.example.repository.WeightRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/weights")
//@CrossOrigin(origins = "*") // Allow frontend access
//public class WeightController {
//
//    private final WeightRepository repo;
//
//    public WeightController(WeightRepository repo) {
//        this.repo = repo;
//    }
//
//    // Add weight
//    @PostMapping
//    public Weight addWeight(@RequestBody Weight weight) {
//        return repo.save(weight);
//    }
//
//    // Get all weights
//    @GetMapping
//    public List<Weight> getAllWeights() {
//        return repo.findAll();
//    }
//}
