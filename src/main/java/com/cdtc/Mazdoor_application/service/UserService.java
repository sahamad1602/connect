package com.cdtc.Mazdoor_application.service;

import com.cdtc.Mazdoor_application.dto.CreateAccountRequest;
import com.cdtc.Mazdoor_application.model.User;
import com.cdtc.Mazdoor_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder; // Uncomment if using Spring Security

    public User createAccount(CreateAccountRequest request) {
        // 1. Check if the phone number is already registered
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("An account with this phone number already exists.");
        }

        // 2. Map DTO to Entity
        User newUser = new User();
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setFullName(request.getFullName());
        newUser.setArea(request.getArea());
        newUser.setSkill(request.getSkill());

        // 3. Handle Password (WARNING: Always hash passwords in production!)
        // newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setPassword(request.getPassword()); // Plain text used here for simplicity

        // 4. Save to Database
        return userRepository.save(newUser);
    }
}
