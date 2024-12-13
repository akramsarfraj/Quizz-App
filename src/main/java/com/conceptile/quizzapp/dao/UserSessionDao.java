package com.conceptile.quizzapp.dao;

import com.conceptile.quizzapp.model.UserSession;
import com.conceptile.quizzapp.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserSessionDao {
    @Autowired
    private UserSessionRepository repository;

    public UserSession generateSession(UserSession session){
        return repository.save(session);
    }

    public boolean checkSession(String sessionId){
        Optional<UserSession> session = repository.findBySession_Id(sessionId);
        return session.isPresent();
    }

    public String getUserName(){
        return repository.getUserName();
    }
}
