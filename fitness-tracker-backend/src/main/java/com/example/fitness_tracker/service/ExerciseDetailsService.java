package com.example.fitness_tracker.service;

import com.example.fitness_tracker.models.ExerciseDetails;
import com.example.fitness_tracker.repositories.ExerciseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseDetailsService {

    @Autowired
    private ExerciseDetailsRepository exerciseDetailsRepository;

    public List<ExerciseDetails> searchExercises(String query) {
        return exerciseDetailsRepository.searchByName(query);
    }
}
