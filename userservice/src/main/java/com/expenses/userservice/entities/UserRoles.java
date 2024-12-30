package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user_roles")
@Data
public class UserRoles extends BaseEntity{

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "userRoles")
    private Set<UserRoleMapping> userRoleMappings;

    @Column(name = "assigned_at")
    private Timestamp assignedAt;
}
