package com.conceptile.quizzapp.repository;

import com.conceptile.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("select q from Question q order by RAND()")
    List<Question> randomQuestion();


}
