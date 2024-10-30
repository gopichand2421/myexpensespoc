package com.expenses.userservice.model;

import com.expenses.userservice.entities.UserRole;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsersDTO implements Serializable {

    private String username;
    private String email;

    private Set<UserRoleDTO> roles = new HashSet<>();
    private UserDetailsDTO userDetailsDTO;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleDTO> roles) {
        this.roles = roles;
    }

    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }

    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }
}
