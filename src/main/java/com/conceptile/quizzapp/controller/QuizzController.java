package com.conceptile.quizzapp.controller;


import com.conceptile.quizzapp.dto.QuizzSummary;
import com.conceptile.quizzapp.model.Question;
import com.conceptile.quizzapp.model.UserAnswer;
import com.conceptile.quizzapp.model.UserSession;
import com.conceptile.quizzapp.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizzController {

    @Autowired
    private QuizzService service;

    @GetMapping("/start_quizz")
    public ResponseEntity<UserSession> startQuizz(){
       return service.startQuizzSession();
    }

    @GetMapping("/random_question/{sessionId}")
    public List<Question> getRandomQuestion(@PathVariable("sessionId") String session_id){
        return service.getRandomQuestion(session_id);
    }

    @PostMapping("/answer/{question_id}")
    public ResponseEntity<String> submitAnswer(@PathVariable("question_id") Long id, @RequestBody UserAnswer answer){
        return service.submitAnswer(id,answer);
    }

    @GetMapping("/submit")
    public ResponseEntity<QuizzSummary> submitQuizz(){
       return service.submitQuizz();
    }
}
