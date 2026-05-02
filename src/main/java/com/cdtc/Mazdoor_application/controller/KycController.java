package com.cdtc.Mazdoor_application.controller;

import com.cdtc.Mazdoor_application.dto.*;
import com.cdtc.Mazdoor_application.service.KycService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kyc/aadhaar")
public class KycController {

    @Autowired
    private KycService kycService;

    @PostMapping("/generate-otp")
    public ResponseEntity<ApiResponse<OtpGenerationData>> generateOtp(
            @Valid @RequestBody AadhaarOtpRequest request,
            @RequestHeader(value = "Authorization", required = false) String token) {

        // In a real app, extract the workerId from the JWT token here
        String workerId = "worker_123";

        OtpGenerationData data = kycService.initiateAadhaarOtp(workerId, request.getAadhaarNumber());

        return ResponseEntity.ok(new ApiResponse<>("success", "OTP sent successfully", data));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResponse<KycDemographicsData>> verifyOtp(
            @Valid @RequestBody VerifyOtpRequest request,
            @RequestHeader(value = "Authorization", required = false) String token) {

        String workerId = "worker_123";

        KycDemographicsData data = kycService.verifyAadhaarOtp(workerId, request.getTransactionId(), request.getOtp());

        return ResponseEntity.ok(new ApiResponse<>("success", "Aadhaar verified successfully", data));
    }
}
