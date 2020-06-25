package com.calgo.pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoinMeetingRequest {

    @JsonProperty(value = "meeting_link")
    private String meetingLink;

    @JsonProperty(value = "meeting_code")
    private String meetingCode;

}
