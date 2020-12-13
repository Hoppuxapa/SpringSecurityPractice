package com.kravchuk.SpringSecurityPractice.domain;


public enum Permission {
    USERS_READ("users:read"),
    ADMIN_READ("admin:read"),
    GUEST_READ("guest:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}