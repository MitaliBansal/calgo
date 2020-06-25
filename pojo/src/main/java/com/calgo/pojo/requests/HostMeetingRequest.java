package com.calgo.pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HostMeetingRequest {

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "meeting_code", required = true)
    private String meetingCode;

}
