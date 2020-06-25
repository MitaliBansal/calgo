package com.calgo.core.service;

import com.calgo.db.entities.MeetingDataEntity;
import com.calgo.db.entities.UserDataEntity;
import com.calgo.db.repository.UserDataRepository;
import com.calgo.pojo.requests.HostMeetingRequest;
import com.calgo.pojo.requests.SignUpRequest;
import com.calgo.pojo.responses.GenericResponse;
import com.calgo.pojo.responses.HostMeetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class HostMeetingService {

    @Autowired
    private UserDataRepository userDataRepository;

    public ResponseEntity signUp(SignUpRequest signUpRequest) {
        try {
            UserDataEntity userDataEntity = new UserDataEntity();
            userDataEntity.setEmail(signUpRequest.getEmail());
            userDataEntity.setUserName(signUpRequest.getUserName());
            userDataRepository.save(userDataEntity);
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage("SignUp successful");
            return new ResponseEntity(genericResponse, HttpStatus.OK);
        } catch (Exception ex) {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage("SignUp was not successful, " + ex.getMessage());
            return new ResponseEntity(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity generateLinkForOneToOneCall(HostMeetingRequest hostMeetingRequest) {
        try {
            UserDataEntity userDataEntity = userDataRepository.findByEmail(hostMeetingRequest.getEmail());
            if(userDataEntity != null) {
                MeetingDataEntity meetingDataEntity = new MeetingDataEntity();
                meetingDataEntity.setUserName(userDataEntity.getUserName());
                meetingDataEntity.setMeetingCode(hostMeetingRequest.getMeetingCode());
                meetingDataEntity.setMeetingType("One-to-one");
                meetingDataEntity.setMeetingLink("m_c_" + meetingDataEntity.getMeetingCode() + "_" + Instant.now().toEpochMilli());
                HostMeetingResponse hostMeetingResponse = new HostMeetingResponse();
                hostMeetingResponse.setGeneratedLink(meetingDataEntity.getMeetingLink());
                return new ResponseEntity(hostMeetingRequest, HttpStatus.OK);
            } else {
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setMessage("First signUp");
                return new ResponseEntity(genericResponse, HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex) {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage(ex.getMessage());
            return new ResponseEntity(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity generateLinkForOneToManyCall(HostMeetingRequest hostMeetingRequest) {
        try {
            UserDataEntity userDataEntity = userDataRepository.findByEmail(hostMeetingRequest.getEmail());
            if(userDataEntity != null) {
                MeetingDataEntity meetingDataEntity = new MeetingDataEntity();
                meetingDataEntity.setUserName(userDataEntity.getUserName());
                meetingDataEntity.setMeetingCode(hostMeetingRequest.getMeetingCode());
                meetingDataEntity.setMeetingType("One-to-many");
                meetingDataEntity.setMeetingLink("m_c_" + meetingDataEntity.getMeetingCode() + "_" + Instant.now().toEpochMilli());
                HostMeetingResponse hostMeetingResponse = new HostMeetingResponse();
                hostMeetingResponse.setGeneratedLink(meetingDataEntity.getMeetingLink());
                return new ResponseEntity(hostMeetingRequest, HttpStatus.OK);
            } else {
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setMessage("First signUp");
                return new ResponseEntity(genericResponse, HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex) {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage(ex.getMessage());
            return new ResponseEntity(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity generateLinkForManyToManyCall(HostMeetingRequest hostMeetingRequest) {
        try {
            UserDataEntity userDataEntity = userDataRepository.findByEmail(hostMeetingRequest.getEmail());
            if(userDataEntity != null) {
                MeetingDataEntity meetingDataEntity = new MeetingDataEntity();
                meetingDataEntity.setUserName(userDataEntity.getUserName());
                meetingDataEntity.setMeetingCode(hostMeetingRequest.getMeetingCode());
                meetingDataEntity.setMeetingType("Many-to-many");
                meetingDataEntity.setMeetingLink("m_c_" + meetingDataEntity.getMeetingCode() + "_" + Instant.now().toEpochMilli());
                HostMeetingResponse hostMeetingResponse = new HostMeetingResponse();
                hostMeetingResponse.setGeneratedLink(meetingDataEntity.getMeetingLink());
                return new ResponseEntity(hostMeetingRequest, HttpStatus.OK);
            } else {
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setMessage("First signUp");
                return new ResponseEntity(genericResponse, HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex) {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage(ex.getMessage());
            return new ResponseEntity(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
