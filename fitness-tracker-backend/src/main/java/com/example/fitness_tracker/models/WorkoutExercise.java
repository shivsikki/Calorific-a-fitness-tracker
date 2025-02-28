package com.example.fitness_tracker.models;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_exercises")
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(nullable = false)
    private Long exerciseDetailsId;

    @Column(nullable = false)
    private int sets;

    @Column(nullable = false)
    private int reps;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private String duration; // Stored in ISO 8601 (e.g., PT10M30S)

    public WorkoutExercise() {}

    public WorkoutExercise(Workout workout, Long exerciseDetailsId, int sets, int reps, double weight, String duration) {
        this.workout = workout;
        this.exerciseDetailsId = exerciseDetailsId;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Workout getWorkout() { return workout; }
    public void setWorkout(Workout workout) { this.workout = workout; }

    public Long getExerciseDetailsId() { return exerciseDetailsId; }
    public void setExerciseDetailsId(Long exerciseDetailsId) { this.exerciseDetailsId = exerciseDetailsId; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }

    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}
