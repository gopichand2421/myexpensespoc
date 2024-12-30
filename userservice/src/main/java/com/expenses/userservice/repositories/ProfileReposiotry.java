package com.expenses.userservice.repositories;

import com.expenses.userservice.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileReposiotry extends JpaRepository<Profile, Integer> {
}
