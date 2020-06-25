package com.calgo.db.repository;

import com.calgo.db.entities.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, Long> {

    UserDataEntity findByEmail(String email);

}
