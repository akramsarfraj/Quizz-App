package com.conceptile.quizzapp.dao;

import com.conceptile.quizzapp.model.UserAnswer;
import com.conceptile.quizzapp.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserAnswerDao {
    @Autowired
    private UserAnswerRepository repository;

    public UserAnswer saveAnswer(UserAnswer answer){
       return repository.save(answer);
    }

    public long totalAnswer(){
        return repository.count();
    }

    public long findTotalCorrect(){
        return repository.totalCorrect();
    }
    public String getAnswerByQId(long qid){
        return repository.getSubmittedAnswer(qid);
    }

}
