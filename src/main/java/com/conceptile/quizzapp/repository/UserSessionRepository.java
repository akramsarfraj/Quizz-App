package com.conceptile.quizzapp.repository;


import com.conceptile.quizzapp.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession,Integer> {

    @Query("select s from UserSession s where s.session_Id = :session_id")
    Optional<UserSession> findBySession_Id(String session_id);


    @Query("select s.user_name from UserSession s")
    String getUserName();


}
