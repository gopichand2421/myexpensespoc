package com.student.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class StudentDetailsDTO {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "firstname")
    private String firstname;
    @JsonProperty(value = "lastname")
    private String lastname;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value="dateofbirth")
    private String dateOfbirth;

    @JsonProperty(value="studentContactDetails")
    List<StudentContactDTO> studentContactDetails;
}
