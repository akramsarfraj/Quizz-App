package com.conceptile.quizzapp.dao;

import com.conceptile.quizzapp.model.Question;
import com.conceptile.quizzapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class QuestionDao {
    @Autowired
    private QuestionRepository repository;

    public List<Question> generateRandomQuestion(){
        return repository.randomQuestion();
    }

    public void saveAllQuestion(List<Question> questions){
        repository.saveAll(questions);
    }

    public long totalQuestion(){
       return repository.count();
    }

    public Optional<Question> findById (long qid){
        return repository.findById(qid);
    }


}
