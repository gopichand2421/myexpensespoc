package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.UserTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserTokens, Integer> {

}
