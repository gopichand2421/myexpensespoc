package com.expenses.userservice.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UsersDTO {

    private String email;
    private String username;
    private String password;

    private List<UserRolesDTO> userRoles;
    private ProfileDTO profileDTO;
}
