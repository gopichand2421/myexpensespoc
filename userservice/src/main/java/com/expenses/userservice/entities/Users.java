package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class Users extends  BaseEntity{

    private String email;
    private String username;
    private String password;


    @OneToMany(mappedBy = "users")
    private Set<UserRoleMapping> userRoleMappings;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Profile userProfile;
}
