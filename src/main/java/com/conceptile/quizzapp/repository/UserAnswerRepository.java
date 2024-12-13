package com.conceptile.quizzapp.repository;

import com.conceptile.quizzapp.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long> {
    @Query("select a.userAnswer from UserAnswer a where a.question_id = ?1")
    String getSubmittedAnswer(long qid);

    @Query("select count(*) from UserAnswer a where a.isCorrect is TRUE ")
    long totalCorrect();


}
