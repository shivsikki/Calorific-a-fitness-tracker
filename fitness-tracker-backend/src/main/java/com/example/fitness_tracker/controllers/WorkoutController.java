package com.example.fitness_tracker.controllers;

import com.example.fitness_tracker.models.Workout;
import com.example.fitness_tracker.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // ✅ Get workout history by user ID
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Workout>> getWorkoutHistory(@PathVariable Long userId) {
        List<Workout> workouts = workoutService.getWorkoutHistory(userId);
        return ResponseEntity.ok(workouts);
    }

    // ✅ Get a single workout by ID
    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Optional<Workout> workout = workoutService.getWorkoutById(id);
        return workout.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Create a new workout
    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout savedWorkout = workoutService.createWorkout(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    // ✅ Update an existing workout
    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        Workout updatedWorkout = workoutService.updateWorkout(id, workout);
        return ResponseEntity.ok(updatedWorkout);
    }

    // ✅ Delete a workout
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
