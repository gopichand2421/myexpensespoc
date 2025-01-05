package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_tokens")
@Setter
@Getter
public class UserTokens{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userToken;

    @Column(name="isexpired")
    private boolean isExpired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users user;
}
