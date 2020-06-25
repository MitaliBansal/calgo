package com.calgo.server.controller;

import com.calgo.core.service.JoinMeetingService;
import com.calgo.pojo.requests.JoinMeetingRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/join-meeting")
public class JoinMeeting {

    @Autowired
    private JoinMeetingService joinMeetingService;

    public void joinMeeting(@Valid @RequestBody JoinMeetingRequest joinMeetingRequest) {
        joinMeetingRequest.setMeetingCode(DigestUtils.sha256Hex(joinMeetingRequest.getMeetingCode()));
        Boolean isVerified = joinMeetingService.verifyDetails(joinMeetingRequest);
        if(isVerified) {
            //Make connection to the link and join it
        } else {
            return;
        }
    }

}
