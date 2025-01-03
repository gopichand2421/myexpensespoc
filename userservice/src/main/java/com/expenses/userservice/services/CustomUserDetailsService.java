package com.expenses.userservice.services;

import com.expenses.userservice.entities.Users;
import com.expenses.userservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findUsernameOrEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username is not Found"));

        return null;
    }
}
