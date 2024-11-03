package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMappingRepository
        extends JpaRepository<UserRoleMapping, Long> {
}
