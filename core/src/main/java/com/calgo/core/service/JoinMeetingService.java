package com.calgo.core.service;

import com.calgo.db.entities.MeetingDataEntity;
import com.calgo.db.repository.MeetingDataRepository;
import com.calgo.pojo.requests.JoinMeetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinMeetingService {

    @Autowired
    private MeetingDataRepository meetingDataRepository;

    public Boolean verifyDetails(JoinMeetingRequest joinMeetingRequest) {
        try {
            MeetingDataEntity meetingDataEntity = meetingDataRepository.findByMeetingLink(joinMeetingRequest.getMeetingLink());
            if(meetingDataEntity==null) {
                return false;
            }else if(joinMeetingRequest.getMeetingCode()==meetingDataEntity.getMeetingCode()) {
                return true;
            }else {
                return false;
            }
        }catch (Exception ex) {
            return false;
        }
    }

}
