package com.cdtc.Mazdoor_application.service;

import com.cdtc.Mazdoor_application.dto.KycDemographicsData;
import com.cdtc.Mazdoor_application.dto.OtpGenerationData;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KycService {

    // Simulating Redis/Database for temporary transaction storage
    // Key: TransactionId, Value: Mocked Data (In production, store hashed Aadhaar/State)
    private final ConcurrentHashMap<String, String> activeTransactions = new ConcurrentHashMap<>();

    public OtpGenerationData initiateAadhaarOtp(String workerId, String aadhaarNumber) {

        // 1. TODO: Implement Rate Limiting check here based on workerId

        // 2. Call External API Gateway (Mocked)
        String externalTransactionId = callExternalGatewayForOtp(aadhaarNumber);

        if (externalTransactionId == null) {
            throw new RuntimeException("Failed to communicate with KYC Gateway");
        }

        // 3. Store the transaction ID temporarily (e.g., 10 minutes expiry in Redis)
        activeTransactions.put(externalTransactionId, aadhaarNumber.substring(8)); // Storing only last 4 digits for safety

        // 4. Return to controller
        return new OtpGenerationData(externalTransactionId);
    }

    public KycDemographicsData verifyAadhaarOtp(String workerId, String transactionId, String otp) {

        // 1. Validate Transaction ID exists
        if (!activeTransactions.containsKey(transactionId)) {
            throw new RuntimeException("Invalid or Expired Transaction ID");
        }

        // 2. Call External API Gateway to verify OTP (Mocked)
        KycDemographicsData verifiedData = callExternalGatewayToVerifyOtp(transactionId, otp);

        if (verifiedData == null) {
            throw new RuntimeException("Invalid OTP provided");
        }

        // 3. Generate internal Session ID for the next step (Selfie Match)
        String internalKycSessionId = "sess_" + UUID.randomUUID().toString();
        verifiedData.setKycSessionId(internalKycSessionId);

        // 4. TODO: Securely store the returned Aadhaar Profile Photo in your DB against the 'internalKycSessionId'
        // Do NOT send the photo to the frontend.

        // 5. Clean up the transaction
        activeTransactions.remove(transactionId);

        return verifiedData;
    }

    // =========================================================================
    // MOCK EXTERNAL GATEWAY CALLS (Replace with RestTemplate or WebClient calls)
    // =========================================================================

    private String callExternalGatewayForOtp(String aadhaarNumber) {
        // Simulate HTTP POST to https://api.setu.co/api/okyc/otp or similar
        // Return a mock vendor transaction ID
        return "txn_" + UUID.randomUUID().toString();
    }

    private KycDemographicsData callExternalGatewayToVerifyOtp(String transactionId, String otp) {
        // Simulate HTTP POST to vendor API with OTP
        // Simulate a successful verification response
        if ("123456".equals(otp)) { // Hardcoding 123456 as the "correct" OTP for testing
            KycDemographicsData data = new KycDemographicsData();
            data.setFullName("Rahul Kumar");
            data.setGender("M");
            data.setDob("1990-05-15");
            return data;
        }
        return null; // Simulate failure
    }
}
