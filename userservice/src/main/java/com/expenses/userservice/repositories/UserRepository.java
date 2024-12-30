package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Users findByEmail(String email);
}
