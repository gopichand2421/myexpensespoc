package com.expenses.userservice.services;

import com.expenses.userservice.entities.Profile;
import com.expenses.userservice.entities.UserRole;
import com.expenses.userservice.entities.UserRoleMapping;
import com.expenses.userservice.entities.Users;
import com.expenses.userservice.exceptions.BadRequestException;
import com.expenses.userservice.exceptions.ResourceNotFoundException;
import com.expenses.userservice.model.UserRolesDTO;
import com.expenses.userservice.model.UsersDTO;
import com.expenses.userservice.repositories.ProfileReposiotry;
import com.expenses.userservice.repositories.UserRepository;
import com.expenses.userservice.repositories.UserRoleMappingRepository;
import com.expenses.userservice.repositories.UserRoleRepository;
import com.expenses.userservice.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserHandlerService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private UserRoleMappingRepository userRoleMappingRepository;
    private ProfileReposiotry profileReposiotry;

    @Autowired
    public UserHandlerService(UserRepository userRepository,
                              UserRoleRepository userRoleRepository,
                              UserRoleMappingRepository userRoleMappingRepository,
                              ProfileReposiotry profileReposiotry){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRoleMappingRepository = userRoleMappingRepository;
        this.profileReposiotry = profileReposiotry;
    }

    @Transactional
    public String createUser(UsersDTO usersDTO){
        UserRole userRole = null;
        Profile profile = null;
        try{
            if(usersDTO != null){
                UserRoleMapping userRoleMapping = new UserRoleMapping();
                if(usersDTO.getUserRoles() == null || usersDTO.getUserRoles().isEmpty() ||
                usersDTO.getUserRoles().get(0).getRoleName().isEmpty()){
                    UserRolesDTO role = new UserRolesDTO();
                    List<UserRolesDTO> userRoleList = new ArrayList<>();
                    role.setRoleName(ApplicationConstants.APP_USER);
                    userRoleList.add(role);
                    usersDTO.setUserRoles(userRoleList);
                }
                if(usersDTO.getProfileDTO() != null){
                    profile = new Profile();
                    profile.setFirstName(usersDTO.getProfileDTO().getFirstName());
                    profile.setLastName(usersDTO.getProfileDTO().getLastName());
                    profile.setPhoneNumber(usersDTO.getProfileDTO().getPhoneNumber());
                }
                userRole = this.userRoleRepository.
                        findByRoleName(usersDTO.getUserRoles().get(0).getRoleName());
                Users user = new Users();
                user.setEmail(usersDTO.getEmail());
                user.setUsername(usersDTO.getUsername());
                user.setPassword(usersDTO.getPassword());
                userRepository.save(user);

                UserRoleMapping roleMapping = new UserRoleMapping();
                roleMapping.setUserRole(userRole);
                roleMapping.setUsers(user);
                if(profile != null){
                    profile.setUsers(user);
                    this.profileReposiotry.save(profile);
                }
                this.userRoleMappingRepository.save(roleMapping);
            }else {
                throw new ResourceNotFoundException("Please provide data");
            }
        }catch (Exception ex){
            throw  new BadRequestException(ex.getMessage());
        }
        return null;
    }

}
