package com.clinic.app.security;

public enum ApplicationUserPermission {
    USER_READ("customer:read"),
    USER_WRITE("customer:write");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
