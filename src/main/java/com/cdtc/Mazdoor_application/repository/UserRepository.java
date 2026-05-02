package com.cdtc.Mazdoor_application.repository;

import com.cdtc.Mazdoor_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to check if a user already exists with this phone number
    boolean existsByPhoneNumber(String phoneNumber);
}
