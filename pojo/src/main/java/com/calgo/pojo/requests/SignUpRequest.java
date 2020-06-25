package com.calgo.pojo.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "user_name", required = true)
    private String userName;

}
