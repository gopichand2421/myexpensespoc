package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer> {

    @Query(value = "select * from user_roles where role_name=?1", nativeQuery = true)
    UserRoles findByRoleName(String roleName);
}
