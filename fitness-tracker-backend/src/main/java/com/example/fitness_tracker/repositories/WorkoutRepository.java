package com.example.fitness_tracker.repositories;

import com.example.fitness_tracker.models.Workout;
import com.example.fitness_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUser(User user);
}
