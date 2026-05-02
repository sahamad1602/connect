package com.cdtc.Mazdoor_application.dto;

import lombok.Data;

@Data
public class KycDemographicsData {
    private String kycSessionId;
    private String fullName;
    private String gender;
    private String dob;

    public String getKycSessionId() {
        return kycSessionId;
    }

    public void setKycSessionId(String kycSessionId) {
        this.kycSessionId = kycSessionId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
