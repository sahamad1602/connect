package com.cdtc.Mazdoor_application.dto;

import lombok.Data;

@Data
public class OtpGenerationData {
    private String transactionId;

    public OtpGenerationData(String transactionId) {
        this.transactionId = transactionId;
    }
}
