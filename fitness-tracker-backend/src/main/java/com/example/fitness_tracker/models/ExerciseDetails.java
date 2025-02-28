package com.example.fitness_tracker.models;
import jakarta.persistence.*;

@Entity
@Table(name = "exercise_details")
public class ExerciseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;  // e.g., DYNAMIC, STATIC

    @Column
    private String muscleGroup; // Example: Chest, Legs, Back

    @Column
    private String description; // Optional: Extra details

    // Default constructor
    public ExerciseDetails() {
    }

    // Parameterized constructor
    public ExerciseDetails(Long id, String name, String type, String muscleGroup, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.muscleGroup = muscleGroup;
        this.description = description;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
