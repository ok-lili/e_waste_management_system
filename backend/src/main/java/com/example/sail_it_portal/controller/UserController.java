package com.example.sail_it_portal.controller;

import com.example.sail_it_portal.model.Users;
import com.example.sail_it_portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // allow calls from React frontend
public class UserController {

    @Autowired
    private UserService userService;

    // -----------------------
    // Register / Create User
    // -----------------------
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        Users createdUser = userService.createUser(user);
        if (createdUser == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // -----------------------
    // Login User
    // -----------------------
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        Users loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedInUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
        return ResponseEntity.ok(loggedInUser);
    }

    // -----------------------
    // Get all users
    // -----------------------
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
