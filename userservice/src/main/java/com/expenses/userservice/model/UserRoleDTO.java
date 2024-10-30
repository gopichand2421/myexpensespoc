package com.expenses.userservice.model;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
