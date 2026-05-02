package com.cdtc.Mazdoor_application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class JobPostRequest {

    @NotBlank(message = "Job title is required")
    private String title;

    private String description;

    @NotBlank(message = "Required skill cannot be blank")
    private String requiredSkill;

    @NotNull(message = "Number of workers required must be specified")
    @Min(value = 1, message = "At least 1 worker is required")
    private Integer numberOfWorkersRequired;

    @NotNull(message = "Daily wage is required")
    @Min(value = 100, message = "Daily wage must be at least 100")
    private Double dailyWage;

    @NotNull(message = "Job date is required")
    @FutureOrPresent(message = "Job date cannot be in the past")
    private LocalDate jobDate;

    @NotBlank(message = "Location address is required")
    private String locationAddress;

    private Double latitude;
    private Double longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public Integer getNumberOfWorkersRequired() {
        return numberOfWorkersRequired;
    }

    public void setNumberOfWorkersRequired(Integer numberOfWorkersRequired) {
        this.numberOfWorkersRequired = numberOfWorkersRequired;
    }

    public Double getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(Double dailyWage) {
        this.dailyWage = dailyWage;
    }

    public LocalDate getJobDate() {
        return jobDate;
    }

    public void setJobDate(LocalDate jobDate) {
        this.jobDate = jobDate;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
