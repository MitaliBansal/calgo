package com.calgo.db.repository;

import com.calgo.db.entities.MeetingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingDataRepository extends JpaRepository<MeetingDataEntity, Long> {

    MeetingDataEntity findByMeetingLink(String meetingLink);

}
