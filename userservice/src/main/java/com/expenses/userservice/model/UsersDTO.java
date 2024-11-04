package com.expenses.userservice.model;


import lombok.Data;
import java.util.List;


@Data
public class UsersDTO {

    private String email;
    private String username;
    private String password;

    private List<UserRolesDTO> userRoles;
    private ProfileDTO profileDTO;
}
