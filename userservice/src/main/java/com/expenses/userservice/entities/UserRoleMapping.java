package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "user_role_mapping")
@Data
public class UserRoleMapping{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRoles userRoles;

    @Column(name = "assigned_at")
    private Timestamp assignedAt;
}
