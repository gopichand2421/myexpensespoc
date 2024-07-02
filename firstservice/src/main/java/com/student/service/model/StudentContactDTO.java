package com.student.service.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class StudentContactDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "addressline1")
    private String addressLine1;

    @JsonProperty(value="addressline2")
    private String addressLine2;

    @JsonProperty(value="landmark")
    private String landMark;

    @JsonProperty(value="mobile")
    private String mobile;

    @JsonProperty(value="homephone")
    private String homePhone;

    @JsonProperty(value="district")
    private String district;

    @JsonProperty(value="state")
    private String state;

    @JsonProperty(value="pincode")
    private String pincode;

    @JsonProperty(value="isprimary")
    private Boolean isprimary;

    @JsonProperty(value = "ispermanent")
    private Boolean ispermanent;
}
