package com.cdtc.Mazdoor_application.dto;


import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class CreateAccountRequest {
    private String phoneNumber;
    private String password;
    private String fullName;
    private String area;
    private String skill;
    private boolean isLookingForWorkToday;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public boolean isLookingForWorkToday() {
        return isLookingForWorkToday;
    }

    public void setLookingForWorkToday(boolean lookingForWorkToday) {
        isLookingForWorkToday = lookingForWorkToday;
    }
}
