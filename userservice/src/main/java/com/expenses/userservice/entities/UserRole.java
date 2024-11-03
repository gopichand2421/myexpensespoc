package com.expenses.userservice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole  extends   BaseEntity{

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "userRole")
    private Set<UserRoleMapping> userRoleMappings;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRoleMapping> getUserRoleMappings() {
        return userRoleMappings;
    }

    public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
        this.userRoleMappings = userRoleMappings;
    }
}
