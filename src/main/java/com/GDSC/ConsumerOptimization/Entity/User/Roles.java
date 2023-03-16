package com.GDSC.ConsumerOptimization.Entity.User;

public enum Roles {
    USER("user"),ADMIN("admin");

    private final String role;

    Roles(String role) {
        this.role = role;
    }
    public String getRoles() {
        return role;
    }
}
