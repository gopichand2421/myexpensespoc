package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query(value = "select * from user_role where role_name=?1", nativeQuery = true)
    UserRole findByRoleName(String roleName);
}
