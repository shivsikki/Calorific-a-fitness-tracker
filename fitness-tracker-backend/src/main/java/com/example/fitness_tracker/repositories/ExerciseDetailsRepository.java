package com.example.fitness_tracker.repositories;

import com.example.fitness_tracker.models.ExerciseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExerciseDetailsRepository extends JpaRepository<ExerciseDetails, Long> {

    @Query("SELECT e FROM ExerciseDetails e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<ExerciseDetails> searchByName(String query);
}
