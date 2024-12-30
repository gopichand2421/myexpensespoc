package com.expenses.userservice.services;

import com.expenses.userservice.entities.Profile;
import com.expenses.userservice.entities.UserRoleMapping;
import com.expenses.userservice.entities.UserRoles;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 *
 * @author Gopichand Senagavarapu
 * @version 1.0.0
 */
@Service
@Slf4j
public class UserHandlerService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private UserRoleMappingRepository userRoleMappingRepository;
    private ProfileReposiotry profileReposiotry;
//    private JwtService jwtService;
//    private AuthenticationManager authenticationManager;

    // paramaterized constructor
    @Autowired
    public UserHandlerService(UserRepository userRepository,
                              UserRoleRepository userRoleRepository,
                              UserRoleMappingRepository userRoleMappingRepository,
                              ProfileReposiotry profileReposiotry
//                              JwtService jwtService,
                              ){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRoleMappingRepository = userRoleMappingRepository;
        this.profileReposiotry = profileReposiotry;
//        this.jwtService = jwtService;
//        this.authenticationManager = authenticationManager;
    }

    //mehtod handles creating user
    @Transactional
    public String createUser(UsersDTO usersDTO){
        UserRoles userRole = null;
        Profile profile = null;
        try{
            Users existingUser =  this.userRepository.findByEmail(usersDTO.getEmail());
            //Below condition always TRUE
            //TODO {Code refactor is required}
            if(Objects.nonNull(usersDTO)){
//               UserRoleMapping userRoleMapping = new UserRoleMapping();
                //This condition for Anomynous user
                if(usersDTO.getUserRoles() == null || usersDTO.getUserRoles().isEmpty() ||
                usersDTO.getUserRoles().get(0).getRoleName().isEmpty()){
                    UserRolesDTO role = new UserRolesDTO();
                    List<UserRolesDTO> userRoleList = new ArrayList<>();
                    //Adding APP_USER role for anomynouse user
                    role.setRoleName(ApplicationConstants.APP_USER);
                    userRoleList.add(role);
                    usersDTO.setUserRoles(userRoleList);
                }
                //condition for checking for profile details
                if(Objects.nonNull(usersDTO.getProfileDTO())){
                    profile = Profile.builder()
                            .setFirstName(usersDTO.getProfileDTO().getFirstName())
                            .setLastName(usersDTO.getProfileDTO().getLastName())
                            .setPhoneNumber(usersDTO.getProfileDTO().getPhoneNumber())
                            .build();
                }
                userRole = this.userRoleRepository.
                        findByRoleName(usersDTO.getUserRoles().get(0).getRoleName());
                Users user = Users.builder()
                        .setEmail(usersDTO.getEmail())
                        .setUserName(usersDTO.getUsername())
                        .setPassword(usersDTO.getPassword())
                        .build();
//                user.setEmail(usersDTO.getEmail());
//                user.setUsername(usersDTO.getUsername());
//                user.setPassword(usersDTO.getPassword());
//                String token = this.jwtService.generateJwtToken(usersDTO.getUsername());
//                log.info("token is: "+token);
                userRepository.save(user);
                UserRoleMapping roleMapping = new UserRoleMapping();
                roleMapping.setUserRoles(userRole);
                roleMapping.setUsers(user);
                roleMapping.setAssignedAt(Timestamp.from(Instant.now()));
                if(Objects.nonNull(profile)){
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

    //delete user method
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
