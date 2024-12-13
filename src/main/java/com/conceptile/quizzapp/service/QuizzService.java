package com.conceptile.quizzapp.service;


import com.conceptile.quizzapp.dao.QuestionDao;
import com.conceptile.quizzapp.dao.UserAnswerDao;
import com.conceptile.quizzapp.dao.UserSessionDao;
import com.conceptile.quizzapp.dto.Detail;

import com.conceptile.quizzapp.dto.QuizzSummary;
import com.conceptile.quizzapp.exception.UserSessionException;
import com.conceptile.quizzapp.model.Question;
import com.conceptile.quizzapp.model.UserAnswer;
import com.conceptile.quizzapp.model.UserSession;
import com.conceptile.quizzapp.util.QuestionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizzService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private UserSessionDao userSessionDao;
    @Autowired
    private UserAnswerDao answerDao;

    /**
     * this method will generate new session for User
     *
     * @return
     */
    public ResponseEntity<UserSession> startQuizzSession(){
        String sessionId = UUID.randomUUID().toString();
        UserSession session = new UserSession();
        session.setSession_Id(sessionId);
        session.setUser_name("USER");

      return ResponseEntity.status(HttpStatus.CREATED).body(userSessionDao.generateSession(session));

    }

    public List<Question> getRandomQuestion(String sessionId){

        //saving question in database
        if(questionDao.totalQuestion() == 0) {
            questionDao.saveAllQuestion(QuestionUtil.questionList());
        }


        if (userSessionDao.checkSession(sessionId)){
            return questionDao.generateRandomQuestion();
        }
        throw  new UserSessionException("Session Expire");

    }

    public ResponseEntity<String> submitAnswer(long id, UserAnswer answer){

        Optional<Question> optional = questionDao.findById(id);
        if(optional.isPresent()){
            String correctanswer = optional.get().getAnswer();
            answer.setCorrect( correctanswer.equalsIgnoreCase(answer.getUserAnswer()) );
            answer.setQuestion_id(id);
            answerDao.saveAnswer(answer);

        }
        String submitted_ans = answerDao.getAnswerByQId( id );

        if (submitted_ans != null) {
            UserAnswer answer1 = answerDao.saveAnswer(answer);
            return ResponseEntity.ok().body("Answer save");
        }
        return ResponseEntity.ok().body("No Question Found");
    }

    public ResponseEntity<QuizzSummary> submitQuizz(){
        QuizzSummary summary = new QuizzSummary();

        long totalSubmission = answerDao.totalAnswer();
        long totalCorrect = answerDao.findTotalCorrect();

        summary.setUser_name(userSessionDao.getUserName());
        summary.setTotalQuestion(questionDao.totalQuestion());
        summary.setTotal_attempt(totalSubmission);
        summary.setTotal_correct(totalCorrect);
        summary.setTotal_incorrect(totalSubmission-totalCorrect);


        List<Detail> list = new ArrayList<>();

        List<Question> questions = questionDao.generateRandomQuestion();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            Detail detail = new Detail();
            detail.setQuestion(q.getQuestion());
            detail.setCorrect_answer(q.getAnswer());

            // finding submitted answer by question id
            String submitted_ans = answerDao.getAnswerByQId( q.getQ_id() );

            if(submitted_ans != null){
                detail.setSubmitted_answer(submitted_ans);
            }else {
                detail.setSubmitted_answer(" ");
            }
            list.add(detail);
        }

        summary.setDetail(list);


        return ResponseEntity.ok().body(summary);


    }
}
