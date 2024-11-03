package com.expenses.userservice.model;

import com.expenses.userservice.entities.UserRole;

import java.util.List;
import java.util.Set;

public class UsersDTO {

    private String email;
    private String username;
    private String password;

    private List<UserRolesDTO> userRoles;

    public List<UserRolesDTO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolesDTO> userRoles) {
        this.userRoles = userRoles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
