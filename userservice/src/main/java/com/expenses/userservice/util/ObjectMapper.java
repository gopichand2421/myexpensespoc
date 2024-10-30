package com.expenses.userservice.util;

import com.expenses.userservice.entities.UserDetails;
import com.expenses.userservice.entities.UserRole;
import com.expenses.userservice.entities.Users;
import com.expenses.userservice.model.UsersDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class ObjectMapper {


    public static Users createUserObject(UsersDTO usersDTO){
        if(usersDTO != null){
            Users users = new Users();
            UserDetails userDetails = new UserDetails();
            userDetails.setAddress(usersDTO.getUserDetailsDTO().getAddress());
            userDetails.setFirstName(usersDTO.getUserDetailsDTO().getFirstName());
            userDetails.setLastName(usersDTO.getUserDetailsDTO().getLastName());
            Set<UserRole> roles = null;
            if(!usersDTO.getRoles().isEmpty()){
             roles =  usersDTO.getRoles().stream().map(obj ->{
                    UserRole role = new UserRole();
                    role.setRole(obj.getRole());
                    return role;
                }).collect(Collectors.toSet());
            }
            users.setEmail(usersDTO.getEmail());
            users.setUsername(usersDTO.getUsername());
            if(roles != null) {
                users.getRoles().addAll(roles);
            }
            users.setUserDetails(userDetails);
            return users;
        }
        return null;
    }
}
