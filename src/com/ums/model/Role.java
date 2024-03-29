package com.ums.model;

public enum Role {
    ADMIN("Admin"),
    USER("User");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

