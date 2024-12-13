package com.conceptile.quizzapp.dto;

public class Detail {
    private String question;
    private String correct_answer;
    private String submitted_answer;


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void setSubmitted_answer(String submitted_answer) {
        this.submitted_answer = submitted_answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getSubmitted_answer() {
        return submitted_answer;
    }
}
