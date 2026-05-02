package com.cdtc.Mazdoor_application.controller;

import com.cdtc.Mazdoor_application.dto.CreateAccountRequest;
import com.cdtc.Mazdoor_application.model.User;
import com.cdtc.Mazdoor_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allows your frontend to make requests to this API
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CreateAccountRequest request) {
        try {
            User savedUser = userService.createAccount(request);

            // Avoid returning the password back to the client
            savedUser.setPassword(null);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            // Handle duplicate phone number exception
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        } catch (Exception e) {
            // Handle general server errors
            return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
