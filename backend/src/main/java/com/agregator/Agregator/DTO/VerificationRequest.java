package com.agregator.Agregator.DTO;


import com.agregator.Agregator.Enums.UserRole;

public class VerificationRequest {
    private String email;
    private String code;
    private UserRole role;

    // Геттеры и сеттеры
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

