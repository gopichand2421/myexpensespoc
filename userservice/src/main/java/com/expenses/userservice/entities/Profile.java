package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profile")
@Data
public class Profile extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
