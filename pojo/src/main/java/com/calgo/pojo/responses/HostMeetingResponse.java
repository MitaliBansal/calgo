package com.calgo.pojo.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HostMeetingResponse {

    @JsonProperty(value = "generated_link")
    private String generatedLink;

}
