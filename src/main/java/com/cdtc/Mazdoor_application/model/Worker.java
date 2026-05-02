package com.cdtc.Mazdoor_application.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    private String area;

    private String skill;

    @Column(name = "looking_for_work_today")
    private boolean isLookingForWorkToday;

    // KYC Data
    @Column(name = "is_kyc_verified")
    private boolean isKycVerified = false;

    private String aadhaarLastFour;
    private String profilePhotoUrl; // URL to the verified selfie

    // System Data
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private Double averageRating = 0.0;
    private Integer totalJobsCompleted = 0;
}