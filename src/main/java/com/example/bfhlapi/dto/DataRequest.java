package com.example.bfhlapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import java.util.List;

public class DataRequest {
    @NotNull(message = "Data array cannot be null")
    @NotEmpty(message = "Data array cannot be empty")
    private List<String> data;
    
    @NotNull(message = "Full name cannot be null")
    @NotEmpty(message = "Full name cannot be empty")
    private String fullName;
    
    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotNull(message = "Roll number cannot be null")
    @NotEmpty(message = "Roll number cannot be empty")
    private String rollNumber;

    // Default constructor
    public DataRequest() {}

    // Constructor with all fields
    public DataRequest(List<String> data, String fullName, String email, String rollNumber) {
        this.data = data;
        this.fullName = fullName;
        this.email = email;
        this.rollNumber = rollNumber;
    }

    // Getters and Setters
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
