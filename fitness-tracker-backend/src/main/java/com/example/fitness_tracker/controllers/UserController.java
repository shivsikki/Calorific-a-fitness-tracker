package com.example.fitness_tracker.controllers;

import com.example.fitness_tracker.models.User;
import com.example.fitness_tracker.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        System.out.println("Received user: " + user);

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Email already in use.\"}");
        }

        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\": \"All fields are required.\"}");
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            // Simulating a token response (in real-world, use JWT)
            return ResponseEntity.ok("{\"token\": \"dummy-jwt-token\", \"role\": \"user\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid email or password.\"}");
        }
    }

    @GetMapping("/me")
    public Optional<User> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return Optional.empty(); // No user is authenticated
        }
        return userRepository.findByEmail(userDetails.getUsername()); // Assuming username is email
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
