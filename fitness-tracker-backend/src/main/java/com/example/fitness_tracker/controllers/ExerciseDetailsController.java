package com.example.fitness_tracker.controllers;

import com.example.fitness_tracker.models.ExerciseDetails;
import com.example.fitness_tracker.service.ExerciseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exercise-details")
@CrossOrigin(origins = "http://localhost:3000")
public class ExerciseDetailsController {

    @Autowired
    private ExerciseDetailsService exerciseDetailsService;

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchExercises(@RequestParam String query) {
        List<ExerciseDetails> exercises = exerciseDetailsService.searchExercises(query);
        Map<String, Object> response = new HashMap<>();
        response.put("exerciseDetailsList", exercises);
        return ResponseEntity.ok(response);
    }
}
