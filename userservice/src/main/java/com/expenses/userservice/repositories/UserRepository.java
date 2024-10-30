package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
