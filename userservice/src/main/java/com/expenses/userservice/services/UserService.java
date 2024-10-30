package com.expenses.userservice.services;

import com.expenses.userservice.entities.Users;
import com.expenses.userservice.model.UsersDTO;
import com.expenses.userservice.repositories.UserRepository;
import com.expenses.userservice.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(UsersDTO usersDTO){
        Users users = ObjectMapper.createUserObject(usersDTO);
        return userRepository.save(users);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
