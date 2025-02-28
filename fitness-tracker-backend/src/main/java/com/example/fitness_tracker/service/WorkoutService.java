package com.example.fitness_tracker.service;

import com.example.fitness_tracker.models.Workout;
import com.example.fitness_tracker.models.User;
import com.example.fitness_tracker.repositories.WorkoutRepository;
import com.example.fitness_tracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    // ✅ Get workout history for a specific user
    public List<Workout> getWorkoutHistory(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return workoutRepository.findByUser(user);
    }

    // ✅ Get a single workout by ID
    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    // ✅ Create a new workout
    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    // ✅ Update an existing workout
    public Workout updateWorkout(Long id, Workout updatedWorkout) {
        return workoutRepository.findById(id).map(existingWorkout -> {
            existingWorkout.setName(updatedWorkout.getName());
            existingWorkout.setDate(updatedWorkout.getDate());
            existingWorkout.setUser(updatedWorkout.getUser());
            existingWorkout.setExercises(updatedWorkout.getExercises());
            return workoutRepository.save(existingWorkout);
        }).orElseThrow(() -> new RuntimeException("Workout not found"));
    }

    // ✅ Delete a workout
    public void deleteWorkout(Long id) {
        if (!workoutRepository.existsById(id)) {
            throw new RuntimeException("Workout not found");
        }
        workoutRepository.deleteById(id);
    }
}
