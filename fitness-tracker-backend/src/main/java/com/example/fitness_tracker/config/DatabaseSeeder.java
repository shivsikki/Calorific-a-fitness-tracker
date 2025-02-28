package com.example.fitness_tracker.config;

import com.example.fitness_tracker.models.ExerciseDetails;
import com.example.fitness_tracker.repositories.ExerciseDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedDatabase(ExerciseDetailsRepository repository) {
        return args -> {
            if (repository.count() == 0) { // Avoid duplicate seeding
                List<ExerciseDetails> exercises = List.of(
                        new ExerciseDetails(null, "Push-up", "DYNAMIC", "Chest", "A bodyweight exercise that works the upper body."),
                        new ExerciseDetails(null, "Squat", "DYNAMIC", "Legs", "A lower-body exercise that strengthens the legs and glutes."),
                        new ExerciseDetails(null, "Plank", "STATIC", "Core", "A core strengthening exercise held in a push-up position."),
                        new ExerciseDetails(null, "Dead-lift", "DYNAMIC", "Back", "A weightlifting exercise that targets the back and legs."),
                        new ExerciseDetails(null, "Bench Press", "DYNAMIC", "Chest", "A weightlifting exercise for upper body strength."),
                        new ExerciseDetails(null, "Lunges", "DYNAMIC", "Legs", "A lower-body movement that strengthens the thighs and glutes."),
                        new ExerciseDetails(null, "Pull-up", "DYNAMIC", "Back", "An upper-body exercise performed by pulling yourself up on a bar."),
                        new ExerciseDetails(null, "Bicep Curl", "DYNAMIC", "Arms", "An isolated movement targeting the biceps."),
                        new ExerciseDetails(null, "Tricep Dips", "DYNAMIC", "Arms", "An exercise that targets the triceps using body weight."),
                        new ExerciseDetails(null, "Leg Press", "DYNAMIC", "Legs", "A resistance exercise for the quadriceps and glutes."),
                        new ExerciseDetails(null, "Shoulder Press", "DYNAMIC", "Shoulders", "A weightlifting exercise that targets the deltoids."),
                        new ExerciseDetails(null, "Russian Twists", "DYNAMIC", "Core", "A core exercise that improves rotational strength."),
                        new ExerciseDetails(null, "Calf Raises", "DYNAMIC", "Legs", "An exercise that strengthens the calf muscles."),
                        new ExerciseDetails(null, "Hammer Curl", "DYNAMIC", "Arms", "A variation of the bicep curl focusing on brachialis."),
                        new ExerciseDetails(null, "Leg Curl", "DYNAMIC", "Legs", "A resistance exercise targeting the hamstrings."),
                        new ExerciseDetails(null, "Chest Fly", "DYNAMIC", "Chest", "A weightlifting movement isolating the pectoral muscles."),
                        new ExerciseDetails(null, "Lat Pulldown", "DYNAMIC", "Back", "A cable machine exercise for lat development."),
                        new ExerciseDetails(null, "Romanian Deadlift", "DYNAMIC", "Legs", "A compound lift focusing on hamstrings and glutes."),
                        new ExerciseDetails(null, "Face Pull", "DYNAMIC", "Shoulders", "An exercise to strengthen rear delts and rotator cuffs."),
                        new ExerciseDetails(null, "Side Plank", "STATIC", "Core", "A core-stabilizing exercise performed on one side."),
                        new ExerciseDetails(null, "Glute Bridge", "DYNAMIC", "Legs", "A hip thrust movement to strengthen glutes."),
                        new ExerciseDetails(null, "Seated Row", "DYNAMIC", "Back", "A pulling movement to build back thickness."),
                        new ExerciseDetails(null, "Farmer’s Walk", "DYNAMIC", "Full Body", "A grip and core strength challenge with heavy weights."),
                        new ExerciseDetails(null, "Overhead Squat", "DYNAMIC", "Legs", "An advanced squat variation improving stability."),
                        new ExerciseDetails(null, "Burpees", "DYNAMIC", "Full Body", "A high-intensity exercise for conditioning."),
                        new ExerciseDetails(null, "Dumbbell Snatch", "DYNAMIC", "Full Body", "An explosive lift improving power and coordination."),
                        new ExerciseDetails(null, "Kettlebell Swing", "DYNAMIC", "Full Body", "A ballistic movement developing strength and endurance."),
                        new ExerciseDetails(null, "Hanging Leg Raise", "DYNAMIC", "Core", "An advanced core exercise for lower abs."),
                        new ExerciseDetails(null, "Box Jump", "DYNAMIC", "Legs", "A plyometric move increasing explosive power."),
                        new ExerciseDetails(null, "Barbell Row", "DYNAMIC", "Back", "A compound movement building upper back strength.")
                );

                repository.saveAll(exercises);
                System.out.println("✅ Seeded initial exercise data! Total: " + exercises.size());
            }
        };
    }
}
