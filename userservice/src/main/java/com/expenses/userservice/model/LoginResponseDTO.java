package com.expenses.userservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginResponseDTO {

    private String jwtToken;
    private Long expiresIn;

}
