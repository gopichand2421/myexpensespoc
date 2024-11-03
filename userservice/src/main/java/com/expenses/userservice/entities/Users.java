package com.expenses.userservice.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users extends  BaseEntity{

    private String email;
    private String username;
    private String password;


    @OneToMany(mappedBy = "users")
    private Set<UserRoleMapping> userRoleMappings;

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

    public Set<UserRoleMapping> getUserRoleMappings() {
        return userRoleMappings;
    }

    public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
        this.userRoleMappings = userRoleMappings;
    }
}
