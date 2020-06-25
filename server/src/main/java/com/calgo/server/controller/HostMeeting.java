package com.calgo.server.controller;

import com.calgo.core.service.HostMeetingService;
import com.calgo.pojo.requests.HostMeetingRequest;
import com.calgo.pojo.requests.SignUpRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/host-meeting")
public class HostMeeting {

    @Autowired
    private HostMeetingService hostMeetingService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        return hostMeetingService.signUp(signUpRequest);
    }

    @RequestMapping(path = "/one-to-one", method = RequestMethod.POST)
    public ResponseEntity generateLinkForOneToOneCall(@Valid @RequestBody HostMeetingRequest hostMeetingRequest) {
        hostMeetingRequest.setMeetingCode(DigestUtils.sha256Hex(hostMeetingRequest.getMeetingCode()));
        return hostMeetingService.generateLinkForOneToOneCall(hostMeetingRequest);
    }

    @RequestMapping(path = "/one-to-many", method = RequestMethod.POST)
    public ResponseEntity generateLinkForOneToManyCall(@Valid @RequestBody HostMeetingRequest hostMeetingRequest) {
        hostMeetingRequest.setMeetingCode(DigestUtils.sha256Hex(hostMeetingRequest.getMeetingCode()));
        return hostMeetingService.generateLinkForOneToManyCall(hostMeetingRequest);
    }

    @RequestMapping(path = "/many-to-many", method = RequestMethod.POST)
    public ResponseEntity generateLinkForGroupCall(@Valid @RequestBody HostMeetingRequest hostMeetingRequest) {
        hostMeetingRequest.setMeetingCode(DigestUtils.sha256Hex(hostMeetingRequest.getMeetingCode()));
        return hostMeetingService.generateLinkForManyToManyCall(hostMeetingRequest);
    }

}
