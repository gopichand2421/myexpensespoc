package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetails, Long> {
}
